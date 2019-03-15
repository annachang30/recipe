//package com.codingdojo.recipes.controllers;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//
//import com.mashape.unirest.http.HttpResponse;
//import com.mashape.unirest.http.JsonNode;
//import com.mashape.unirest.http.Unirest;
//import com.mashape.unirest.http.exceptions.UnirestException;
//
////import com.codingdojo.recipes.services.RecipeService;
//
//@Controller
//public class TestCtrl {
////	private final RecipeService rS;
////	
////	public RecipesCtrl(RecipeService rS) {
////		this.rS = rS;
////	}
//	
//	@GetMapping("/")
//	public String index() {
//		try {
//			HttpResponse<JsonNode> response = Unirest.get("https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/recipes/findByIngredients?number=5&ranking=1&ingredients=apples%2Cflour%2Csugar")
//					.header("X-RapidAPI-Key", "3f19ab4974mshfafac565d3e6a08p1c4e99jsn8daffc298e56")
//					.asJson();
//		} catch (UnirestException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return "index.jsp";
//	}
//
//
//}
////APIkey: 3f19ab4974mshfafac565d3e6a08p1c4e99jsn8daffc298e56
////X-RapidAPI-Key
////https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/recipes/findByIngredients?number=5&ranking=1&ingredients=beef