package com.recipesharing.recipe_service.repository;

import com.recipesharing.recipe_service.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    List<Recipe> findByCategory_CategoryId(Long categoryId);
}
