package com.recipesharing.ingredient_service.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
@Valid
public class SavedIngredient {
    @Id
    private ObjectId savedIngredientId;

    @NotNull(message = "UserId required")
    private Long userId;

    @NotNull(message = "RecipeId is required")
    private Long recipeId;

    @NotEmpty(message = "Ingredient list is required")
    private List<@NotBlank(message = "Ingredients cannot be empty") String> ingredients;
}
