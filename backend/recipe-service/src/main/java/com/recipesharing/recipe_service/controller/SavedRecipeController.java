package com.recipesharing.recipe_service.controller;

import com.recipesharing.recipe_service.dto.SavedRecipeDTO;
import com.recipesharing.recipe_service.dto.SavedRecipesDTO;
import com.recipesharing.recipe_service.model.SavedRecipe;
import com.recipesharing.recipe_service.service.SavedRecipeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/savedRecipe")
public class SavedRecipeController {

    private final SavedRecipeService savedRecipeService;

    @Autowired
    public SavedRecipeController(SavedRecipeService savedRecipeService) {
        this.savedRecipeService = savedRecipeService;
    }

    @PostMapping
    public ResponseEntity<SavedRecipe> createSavedRecipe(@Valid @RequestBody SavedRecipeDTO savedRecipeDTO) {
        SavedRecipe savedRecipe = savedRecipeService.createSavedRecipe(savedRecipeDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedRecipe);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<List<SavedRecipesDTO>> getSavedRecipesByUserId(@PathVariable Long userId) {
        List<SavedRecipesDTO> favouriteRecipes = savedRecipeService.getSavedRecipesByUserId(userId);
        return ResponseEntity.ok().body(favouriteRecipes);
    }

}
