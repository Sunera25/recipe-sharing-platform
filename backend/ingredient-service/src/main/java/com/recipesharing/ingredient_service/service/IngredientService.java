package com.recipesharing.ingredient_service.service;

import com.recipesharing.ingredient_service.model.Ingredient;
import com.recipesharing.ingredient_service.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class IngredientService {

    private static final Logger logger = Logger.getLogger(IngredientService.class.getName());
    private final IngredientRepository ingredientRepository;

    @Autowired
    public IngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    public ResponseEntity<Ingredient> getIngredientByRecipeId(Long recipeId) {
        try {
            Ingredient ingredients = ingredientRepository.findByRecipeId(recipeId);
            if ( ingredients == null || ingredients.getIngredients().isEmpty()) {
                logger.warning("No ingredients found for recipe id " + recipeId);
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(ingredients);
        }catch (Exception e) {
            logger.log(Level.SEVERE,"Error while fetching ingredients from recipe id " + recipeId , e);
            return ResponseEntity.status(500).build();
        }
    }


    public ResponseEntity<Ingredient> createIngredient(Ingredient ingredient) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(ingredientRepository.save(ingredient));
        }catch (Exception e) {
            logger.log(Level.SEVERE, "Error while creating ingredient from recipe id " + ingredient.getRecipeId(), e);
            return ResponseEntity.status(500).build();
        }
    }

}
