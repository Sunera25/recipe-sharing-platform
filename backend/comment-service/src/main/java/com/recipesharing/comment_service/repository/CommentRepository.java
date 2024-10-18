package com.recipesharing.comment_service.repository;

import com.recipesharing.comment_service.model.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CommentRepository extends MongoRepository<Comment, Long> {
    List<Comment> findByRecipeId(Long id);
}
