package com.recipesharing.ingredient_service.repository;

import com.recipesharing.ingredient_service.model.Ingredient;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IngredientRepository extends MongoRepository<Ingredient, ObjectId> {
    Ingredient findByRecipeId(Long id);
}
