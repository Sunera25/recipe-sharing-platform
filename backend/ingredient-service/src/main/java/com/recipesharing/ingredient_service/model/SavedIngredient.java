package com.recipesharing.ingredient_service.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
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
@Builder
@Valid
public class SavedIngredient {
    @Id
    private ObjectId savedIngredientId;

    private Long userId;
    private Long recipeId;
    private List<@NotBlank(message = "Ingredients cannot be empty") String> ingredients;
}
