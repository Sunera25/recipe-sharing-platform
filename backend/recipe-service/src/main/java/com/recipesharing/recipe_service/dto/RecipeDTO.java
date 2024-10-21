package com.recipesharing.recipe_service.dto;

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
@Builder
@Valid
public class RecipeDTO {

    @NotNull(message = "Recipe name required")
    @NotBlank(message = "Recipe name can't be blank")
    private String recipeName;

    @NotNull(message = "Recipe description required")
    @NotBlank(message = "Recipe description can't be blank")
    private String recipeDescription;

    @NotNull(message = "Image URL required")
    @NotBlank(message = "Image URL can't be blank")
    private String imageUrl;

    @NotNull(message = "Category ID URL required")
    private Long categoryId;

    @NotEmpty(message = "At least one step required")
    private List<@NotBlank(message = "Step can't be a blank") String> steps;
}
