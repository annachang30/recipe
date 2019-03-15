package com.codingdojo.recipes.services;

import org.springframework.stereotype.Service;

import com.codingdojo.recipes.models.Ingredient;
import com.codingdojo.recipes.respositories.IngredientRepo;

@Service
public class IngredientService {
	private final IngredientRepo iR;
	
	public IngredientService(IngredientRepo iR) {
		this.iR = iR;
	}
	
	public Ingredient createIngredient(Ingredient i) {
		Ingredient ingCreated=iR.save(i);
		return ingCreated;
	}

}
