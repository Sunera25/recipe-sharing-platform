package com.recipesharing.recipe_service.service;

import com.recipesharing.recipe_service.dto.SavedRecipeDTO;
import com.recipesharing.recipe_service.dto.SavedRecipesDTO;
import com.recipesharing.recipe_service.model.Recipe;
import com.recipesharing.recipe_service.model.SavedRecipe;
import com.recipesharing.recipe_service.repository.RecipeRepository;
import com.recipesharing.recipe_service.repository.SavedRecipeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class SavedRecipeService {

    private final static Logger logger = LoggerFactory.getLogger(SavedRecipeService.class);
    private final SavedRecipeRepository savedRecipeRepository;
    private final RecipeRepository recipeRepository;

    @Autowired
    public SavedRecipeService(SavedRecipeRepository savedRecipeRepository, RecipeRepository recipeRepository) {
        this.savedRecipeRepository = savedRecipeRepository;
        this.recipeRepository = recipeRepository;
    }

    //add a favourite recipe
    public SavedRecipe createSavedRecipe(SavedRecipeDTO savedRecipeDTO) {
        //make sure that recipe exists with recipe ID
        if (!recipeRepository.existsByRecipeId(savedRecipeDTO.getRecipeId())) {
            throw new NoSuchElementException("Recipe with id " + savedRecipeDTO.getRecipeId() + " does not exist");
        }
        SavedRecipe savedRecipe = SavedRecipe.builder()
                .recipeId(savedRecipeDTO.getRecipeId())
                .userId(savedRecipeDTO.getUserId())
                .build();

        return savedRecipeRepository.save(savedRecipe);

    }

    //Fetch all favourite recipes for a user
    public List<SavedRecipesDTO> getSavedRecipesByUserId(Long userId) {

        List<SavedRecipesDTO> favouriteRecipesList = new ArrayList<>();
        List<SavedRecipe> favouriteRecipes = savedRecipeRepository.findByUserId(userId);

        for (SavedRecipe saveRecipe : favouriteRecipes) {
            Recipe recipe = recipeRepository.findById(saveRecipe.getRecipeId())
                    .orElseThrow(() -> new NoSuchElementException("Recipe Not Found at id" + saveRecipe.getRecipeId()));
            SavedRecipesDTO savedRecipesDTO = SavedRecipesDTO.builder()
                    .recipeName(recipe.getRecipeName())
                    .recipeImageURL(recipe.getRecipeImageUrl())
                    .build();
            favouriteRecipesList.add(savedRecipesDTO);
        }

        return favouriteRecipesList;
    }
}
