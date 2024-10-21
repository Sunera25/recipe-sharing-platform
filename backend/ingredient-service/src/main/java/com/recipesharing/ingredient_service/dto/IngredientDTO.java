package com.recipesharing.ingredient_service.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Valid
public class IngredientDTO {

    @NotNull(message = "RecipeId is required")
    private Long recipeId;

    @NotNull(message = "Ingredients list is required")
    @Size(min = 1, message = "Ingredient list must contain at least one element")
    private List<@NotBlank(message = "Ingredients cannot be empty") String> ingredients;

}
