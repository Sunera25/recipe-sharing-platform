package com.recipesharing.ingredient_service.repository;

import com.recipesharing.ingredient_service.model.SavedIngredient;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SavedIngredientsRepository extends MongoRepository<SavedIngredient, ObjectId> {
    List<SavedIngredient> findByUserId(Long userId);
}
