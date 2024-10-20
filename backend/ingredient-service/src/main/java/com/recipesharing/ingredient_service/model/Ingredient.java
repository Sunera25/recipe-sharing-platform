package com.recipesharing.ingredient_service.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
@Valid
public class Ingredient {
    @Id
    private ObjectId ingredientId;

    @NotNull(message = "RecipeId is required")
    private Long recipeId;

    @NotNull(message = "Ingredients list is required")
    @Size (min = 1 , message = "Ingredient list must contain at least one element")
    private List<@NotBlank(message = "Ingredients cannot be empty") String> ingredients;
}
