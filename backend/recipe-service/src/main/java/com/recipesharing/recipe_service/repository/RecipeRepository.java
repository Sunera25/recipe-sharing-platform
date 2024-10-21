package com.recipesharing.recipe_service.repository;

import com.recipesharing.recipe_service.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    List<Recipe> findByCategory_CategoryId(Long categoryId);

    @Query(
            "SELECT p FROM Recipe p WHERE " +
                    "LOWER(p.recipeName) LIKE (CONCAT('%', :keyword ,'%'))"
    )
    List<Recipe> searchRecipes(String keyword);

    Boolean existsByRecipeId(Long recipeId);


}
