package com.recipesharing.recipe_service.model;

import com.recipesharing.recipe_service.dto.RecipeDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SavedRecipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long savedRecipeId;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private Long recipeId;
}
