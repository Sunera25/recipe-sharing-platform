package com.recipesharing.ingredient_service.model;

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
public class Ingredient {
    @Id
    private ObjectId ingredientId;

    private Long recipeId;
    private List<String> ingredients;
}
