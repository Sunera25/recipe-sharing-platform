package com.recipesharing.ingredient_service.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Valid
@Builder
public class SavedIngredientDTO {

    @NotNull(message = "UserId required")
    private Long userId;

    @NotNull(message = "RecipeId is required")
    private Long recipeId;

    @NotEmpty(message = "Ingredient list is required")
    private List<@NotBlank(message = "Ingredients cannot be empty") String> ingredients;

}
