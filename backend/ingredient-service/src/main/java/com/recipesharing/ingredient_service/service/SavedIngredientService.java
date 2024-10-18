package com.recipesharing.ingredient_service.service;

import com.recipesharing.ingredient_service.exeption.SavedIngredientServiceException;
import com.recipesharing.ingredient_service.model.SavedIngredient;
import com.recipesharing.ingredient_service.repository.SavedIngredientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class SavedIngredientService {

    public static final Logger logger = Logger.getLogger(SavedIngredientService.class.getName());
    private final SavedIngredientsRepository savedIngredientsRepository;

    @Autowired
    public SavedIngredientService(SavedIngredientsRepository savedIngredientsRepository) {
        this.savedIngredientsRepository = savedIngredientsRepository;
    }

    public List<SavedIngredient> getSavedIngredientByUserId(Long userId) {
        try{
            List<SavedIngredient> savedIngredients = savedIngredientsRepository.findByUserId(userId);
            if(savedIngredients.isEmpty()){
                logger.info("No saved ingredients found for user id " + userId);
            }
            return savedIngredients;
        } catch (Exception e) {
            logger.log(Level.SEVERE,"Error while getting saved ingredients for user id " + userId, e);
            throw new SavedIngredientServiceException("Error while getting saved ingredients for user id " + userId, e);
        }
    }

    public SavedIngredient addSavedIngredient(SavedIngredient savedIngredient) {
        try{
            return savedIngredientsRepository.save(savedIngredient);
        } catch (Exception e) {
            logger.log(Level.SEVERE,"Error while adding saved ingredient " + savedIngredient, e);
            throw new SavedIngredientServiceException("Error while adding saved ingredient " + savedIngredient, e);
        }
    }

}
