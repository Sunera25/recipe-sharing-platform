package com.recipesharing.comment_service.repository;

import com.recipesharing.comment_service.model.Comment;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends MongoRepository<Comment, ObjectId> {
    List<Comment> findByRecipeId(Long id);

    Long countByRecipeIdAndUserId(Long recipeId, Long userId);
}
