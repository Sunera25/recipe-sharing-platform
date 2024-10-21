package com.recipesharing.ingredient_service.controller;

import com.recipesharing.ingredient_service.dto.IngredientDTO;
import com.recipesharing.ingredient_service.model.Ingredient;
import com.recipesharing.ingredient_service.service.IngredientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
        Ingredient ingredients = ingredientService.getIngredientByRecipeId(recipeId);
        return ResponseEntity.ok().body(ingredients);
    }

    @PostMapping
    public ResponseEntity<Ingredient> createIngredient(@Valid @RequestBody IngredientDTO ingredientDTO) {
        Ingredient savedIngredient = ingredientService.createIngredient(ingredientDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedIngredient);
    }

}
