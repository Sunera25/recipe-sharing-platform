package com.recipesharing.recipe_service.service;

import com.recipesharing.recipe_service.dto.CategoryDTO;
import com.recipesharing.recipe_service.exception.AlreadyExistsException;
import com.recipesharing.recipe_service.model.Category;
import com.recipesharing.recipe_service.repository.CategoryRepository;
import com.recipesharing.recipe_service.repository.RecipeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CategoryService {

    private final static Logger logger = LoggerFactory.getLogger(CategoryService.class.getName());
    private final CategoryRepository categoryRepository;
    private final RecipeRepository recipeRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository, RecipeRepository recipeRepository) {
        this.categoryRepository = categoryRepository;
        this.recipeRepository = recipeRepository;
    }

    //save a new category
    public Category createCategory(CategoryDTO categoryDTO) {
        //validate if category already exists
        if (categoryRepository.existsByCategoryName(categoryDTO.getCategoryName())) {
            logger.error("Category already exists by name {} ", categoryDTO.getCategoryName());
            throw new AlreadyExistsException("Category already exists by name: " + categoryDTO.getCategoryName());
        }
        Category newCategory = Category.builder()
                .categoryName(categoryDTO.getCategoryName())
                .categoryImageUrl(categoryDTO.getImageUrl())
                .build();
        return categoryRepository.save(newCategory);
    }

    //Fetch all categories
    public List<Category> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        if (categories.isEmpty()) {
            logger.error("No categories found");
            throw new NoSuchElementException("No categories found");
        }
        return categories;
    }
}
