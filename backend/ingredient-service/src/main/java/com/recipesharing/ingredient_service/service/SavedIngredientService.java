package com.recipesharing.ingredient_service.service;

import com.recipesharing.ingredient_service.model.SavedIngredient;
import com.recipesharing.ingredient_service.repository.SavedIngredientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class SavedIngredientService {

    public static final Logger logger = Logger.getLogger(SavedIngredientService.class.getName());
    private final SavedIngredientsRepository savedIngredientsRepository;

    @Autowired
    public SavedIngredientService(SavedIngredientsRepository savedIngredientsRepository) {
        this.savedIngredientsRepository = savedIngredientsRepository;
    }


    //service to get ingredients for a specific recipe
    public List<SavedIngredient> getSavedIngredientByUserId(Long userId) {
        List<SavedIngredient> savedIngredients = savedIngredientsRepository.findByUserId(userId);
        if (savedIngredients.isEmpty()) {
            logger.info("No saved ingredients found for user id " + userId);
            throw new IllegalArgumentException("No saved ingredients found for user id " + userId);
        }
        return savedIngredients;
    }

    //service to add an ingredients of a recipe for a customer
    public SavedIngredient addSavedIngredient(SavedIngredient savedIngredient) {
        return savedIngredientsRepository.save(savedIngredient);
    }

}
