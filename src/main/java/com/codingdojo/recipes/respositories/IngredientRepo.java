package com.codingdojo.recipes.respositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.recipes.models.Ingredient;

public interface IngredientRepo extends CrudRepository<Ingredient, Long>{
	List<Ingredient> findAll();
}
