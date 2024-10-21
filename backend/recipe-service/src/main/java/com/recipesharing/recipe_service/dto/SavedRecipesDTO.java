package com.recipesharing.recipe_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SavedRecipesDTO extends SavedRecipeDTO {

    private String recipeName;
    private String recipeImageURL;
}
