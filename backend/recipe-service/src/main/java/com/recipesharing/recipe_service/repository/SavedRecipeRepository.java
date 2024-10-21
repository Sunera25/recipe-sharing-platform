package com.recipesharing.recipe_service.repository;

import com.recipesharing.recipe_service.model.SavedRecipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SavedRecipeRepository extends JpaRepository<SavedRecipe, Long> {
    List<SavedRecipe> findByUserId(Long userId);
}
