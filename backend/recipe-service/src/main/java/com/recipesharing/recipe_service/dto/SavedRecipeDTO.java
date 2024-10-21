package com.recipesharing.recipe_service.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Valid
public class SavedRecipeDTO {

    @NotNull(message = "User ID is required")
    private Long userId;

    @NotNull(message = "Recipe ID is required")
    private Long recipeId;
}
