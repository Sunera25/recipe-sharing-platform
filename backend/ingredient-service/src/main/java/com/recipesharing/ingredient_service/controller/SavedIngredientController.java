package com.recipesharing.ingredient_service.controller;

import com.recipesharing.ingredient_service.model.SavedIngredient;
import com.recipesharing.ingredient_service.service.SavedIngredientService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/saved-ingredients")
public class SavedIngredientController {

    private final SavedIngredientService savedIngredientService;

    @Autowired
    public SavedIngredientController(SavedIngredientService savedIngredientService) {
        this.savedIngredientService = savedIngredientService;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<SavedIngredient>> getSavedIngredientsByUserId(@PathVariable Long userId) {
        List<SavedIngredient> savedIngredients = savedIngredientService.getSavedIngredientByUserId(userId);
        return ResponseEntity.ok(savedIngredients);
    }

    @PostMapping
    public ResponseEntity<SavedIngredient> createSavedIngredient(@Valid @RequestBody SavedIngredient savedIngredient) {
        SavedIngredient createdSavedIngredient = savedIngredientService.addSavedIngredient(savedIngredient);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSavedIngredient);
    }

}
