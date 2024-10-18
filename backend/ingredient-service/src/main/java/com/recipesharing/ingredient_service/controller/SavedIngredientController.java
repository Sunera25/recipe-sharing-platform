package com.recipesharing.ingredient_service.controller;

import com.recipesharing.ingredient_service.exeption.SavedIngredientServiceException;
import com.recipesharing.ingredient_service.model.SavedIngredient;
import com.recipesharing.ingredient_service.service.SavedIngredientService;
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
        try {
            List<SavedIngredient> savedIngredients = savedIngredientService.getSavedIngredientByUserId(userId);
            if (savedIngredients == null) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(savedIngredients);
        }catch (SavedIngredientServiceException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping
    public ResponseEntity<SavedIngredient> createSavedIngredient(@RequestBody SavedIngredient savedIngredient) {
        try {
            SavedIngredient createdSavedIngredient = savedIngredientService.addSavedIngredient(savedIngredient);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdSavedIngredient);
        }catch (SavedIngredientServiceException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
