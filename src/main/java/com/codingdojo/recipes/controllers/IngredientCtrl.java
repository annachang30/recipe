package com.codingdojo.recipes.controllers;

import javax.validation.Valid;

import org.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.recipes.models.Ingredient;
import com.codingdojo.recipes.services.IngredientService;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;


@Controller
public class IngredientCtrl {
	private final IngredientService iS;
	
	public IngredientCtrl(IngredientService iS) {
		this.iS = iS;
	}
	
	@GetMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@GetMapping("/recipes/new")
	public String ingredients(@ModelAttribute("recipeObj") Ingredient recipe) {
		return "newRecipe.jsp";
	}
	
	@PostMapping("recipes/new")
	public String createRecipe(@Valid @ModelAttribute("recipeObj") Ingredient ingredient, BindingResult result) {
		if(result.hasErrors()) {
			System.out.println("error");
			return "newRecipe.jsp";
		}
		else {
			Ingredient ingName = iS.createIngredient(ingredient);
			String firstIng = ingName.getFirstIng();
			String secondIng = ingName.getSecondIng();
	
			System.out.println("ingredient 1: " + firstIng);
			System.out.println("ingredient 2: " + secondIng);
			
			return "redirect:/recipes/"+firstIng+"/"+secondIng; 
		}	
	}
	
	
	@GetMapping("/recipes/{ingredient}/{ingredient2}")
	public String showRecipies(Model model, @PathVariable("ingredient") String in, @PathVariable("ingredient2") String in2) {
		model.addAttribute("food", getFood(in, in2));
		return "recipes.jsp";
	}
	
	
	public JSONArray getFood(String ingre, String ingre2) {
		HttpResponse<JsonNode> response = null;
		JSONArray a = null;
		try {
			response = Unirest.get("https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/recipes/findByIngredients?number=5&ranking=1&ingredients="+ingre+"%2C"+ingre2)
				.header("X-RapidAPI-Key", "3f19ab4974mshfafac565d3e6a08p1c4e99jsn8daffc298e56")
				.asJson();
			a = response.getBody().getArray();
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return a;
	}
	
	@GetMapping("/recipeID/{id}")
	public String showDetail(Model model, @PathVariable("id") String id) {
		model.addAttribute("detail", getDetail(id));
		return "oneRecipe.jsp";
	}
	
	public JSONArray getDetail(String id) {
		HttpResponse<JsonNode> response = null;
		JSONArray i = null;
		try {
			response = Unirest.get("https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/recipes/"+id+"/information")
			.header("X-RapidAPI-Key", "3f19ab4974mshfafac565d3e6a08p1c4e99jsn8daffc298e56")
			.asJson();
			i = response.getBody().getArray();
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
	}

}