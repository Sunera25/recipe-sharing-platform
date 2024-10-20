package com.recipesharing.ingredient_service.service;

import com.recipesharing.ingredient_service.model.Ingredient;
import com.recipesharing.ingredient_service.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.logging.Logger;

@Service
public class IngredientService {

    private static final Logger logger = Logger.getLogger(IngredientService.class.getName());
    private final IngredientRepository ingredientRepository;

    @Autowired
    public IngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    //Get ingredients for a recipe
    public Ingredient getIngredientByRecipeId(Long recipeId) {
        Ingredient ingredients = ingredientRepository.findByRecipeId(recipeId);
        if (ingredients == null) {
            logger.warning("No ingredients found for recipe id " + recipeId);
            throw new NoSuchElementException("No ingredients found for recipe id " + recipeId);
        }
        return ingredients;
    }

    //save ingredients of a recipe
    public Ingredient createIngredient(Ingredient ingredient) {
        if (ingredientRepository.existsByRecipeId(ingredient.getRecipeId())) {
            logger.warning("Ingredient with id " + ingredient.getRecipeId() + " already exists");
            throw new IllegalArgumentException("Ingredients for recipe id " + ingredient.getRecipeId() + " already exists");
        }
        return ingredientRepository.save(ingredient);
    }

}
