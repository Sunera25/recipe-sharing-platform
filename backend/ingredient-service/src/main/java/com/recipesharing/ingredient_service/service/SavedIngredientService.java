package com.recipesharing.ingredient_service.service;

import com.recipesharing.ingredient_service.dto.SavedIngredientDTO;
import com.recipesharing.ingredient_service.model.SavedIngredient;
import com.recipesharing.ingredient_service.repository.SavedIngredientsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SavedIngredientService {

    public static final Logger logger = LoggerFactory.getLogger(SavedIngredientService.class);
    private final SavedIngredientsRepository savedIngredientsRepository;

    @Autowired
    public SavedIngredientService(SavedIngredientsRepository savedIngredientsRepository) {
        this.savedIngredientsRepository = savedIngredientsRepository;
    }


    //service to get ingredients for a specific recipe
    public List<SavedIngredient> getSavedIngredientByUserId(Long userId) {
        List<SavedIngredient> savedIngredients = savedIngredientsRepository.findByUserId(userId);
        if (savedIngredients.isEmpty()) {
            logger.warn("No saved ingredients found for user id {}" , userId);
            throw new IllegalArgumentException("No saved ingredients found for user id " + userId);
        }
        return savedIngredients;
    }

    //service to add an ingredients of a recipe for a customer
    public SavedIngredient addSavedIngredient(SavedIngredientDTO savedIngredientDTO) {
        SavedIngredient newSavedIngredient = SavedIngredient.builder()
                .recipeId(savedIngredientDTO.getRecipeId())
                .userId(savedIngredientDTO.getUserId())
                .ingredients(savedIngredientDTO.getIngredients())
                .build();
        return savedIngredientsRepository.save(newSavedIngredient);
    }

}
