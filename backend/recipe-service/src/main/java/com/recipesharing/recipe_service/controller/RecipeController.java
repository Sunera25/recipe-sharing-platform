package com.recipesharing.recipe_service.controller;

import com.recipesharing.recipe_service.dto.RecipeDTO;
import com.recipesharing.recipe_service.model.Recipe;
import com.recipesharing.recipe_service.service.RecipeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recipe")
public class RecipeController {

    private final RecipeService recipeService;

    @Autowired
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @PostMapping
    public ResponseEntity<Recipe> createRecipe(@Valid @RequestBody RecipeDTO recipeDTO) {
        Recipe newRecipe = recipeService.createRecipe(recipeDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(newRecipe);
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<Recipe>> getRecipesByCategoryId(@PathVariable Long categoryId) {
        List<Recipe> recipeListByCategory = recipeService.getRecipesByCategoryId(categoryId);
        return ResponseEntity.ok().body(recipeListByCategory);
    }

    @GetMapping("/search/{keyword}")
    public ResponseEntity<List<Recipe>> searchRecipes(@PathVariable String keyword) {
        List<Recipe> searchRecipes = recipeService.searchRecipes(keyword);
        if (searchRecipes.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok().body(searchRecipes);
    }

}
