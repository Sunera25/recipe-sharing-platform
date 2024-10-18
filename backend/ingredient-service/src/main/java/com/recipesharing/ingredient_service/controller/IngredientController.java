package com.recipesharing.ingredient_service.controller;

import com.recipesharing.ingredient_service.model.Ingredient;
import com.recipesharing.ingredient_service.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/ingredients")
public class IngredientController {

    private final IngredientService ingredientService;

    @Autowired
    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @GetMapping("/recipe/{recipeId}")
    public ResponseEntity<Ingredient> getIngredientByRecipeId(@PathVariable Long recipeId) {
        return ingredientService.getIngredientByRecipeId(recipeId);
    }

    @PostMapping("/")
    public ResponseEntity<Ingredient> createIngredient(@RequestBody Ingredient ingredient) {
        return ingredientService.createIngredient(ingredient);
    }

}
