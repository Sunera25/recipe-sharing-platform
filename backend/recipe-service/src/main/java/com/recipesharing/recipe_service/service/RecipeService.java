package com.recipesharing.recipe_service.service;

import com.recipesharing.recipe_service.dto.RecipeDTO;
import com.recipesharing.recipe_service.model.Category;
import com.recipesharing.recipe_service.model.Recipe;
import com.recipesharing.recipe_service.model.Step;
import com.recipesharing.recipe_service.repository.CategoryRepository;
import com.recipesharing.recipe_service.repository.RecipeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class RecipeService {

    private final static Logger logger = LoggerFactory.getLogger(RecipeService.class.getName());
    private final RecipeRepository recipeRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public RecipeService(RecipeRepository recipeRepository, CategoryRepository categoryRepository) {
        this.recipeRepository = recipeRepository;
        this.categoryRepository = categoryRepository;
    }

    //get recipes by category ids
    public List<Recipe> getRecipesByCategoryId(Long categoryId) {
        List<Recipe> recipes = recipeRepository.findByCategory_CategoryId(categoryId);
        if (recipes.isEmpty()) {
            logger.warn("No recipes found for category id {}", categoryId);
            throw new NoSuchElementException("No recipes found for category id " + categoryId);
        }
        return recipes;
    }

    public Recipe createRecipe(RecipeDTO recipeDTO) {

        Category category = categoryRepository.findById(recipeDTO.getCategoryId())
                .orElseThrow(() -> new NoSuchElementException("Category id " + recipeDTO.getCategoryId() + " not found"));

        //convert String step list to Step type
        List<Step> steps = new ArrayList<>();
        for (String step : recipeDTO.getSteps()) {
            Step stepDTO = Step.builder()
                    .step(step)
                    .build();
            steps.add(stepDTO);
        }

        //build a recipe object to save
        Recipe savedRecipe = Recipe.builder()
                .recipeName(recipeDTO.getRecipeName())
                .recipeDescription(recipeDTO.getRecipeDescription())
                .recipeImageUrl(recipeDTO.getImageUrl())
                .category(category)
                .stepsList(steps)
                .build();
        return recipeRepository.save(savedRecipe);
    }
}
