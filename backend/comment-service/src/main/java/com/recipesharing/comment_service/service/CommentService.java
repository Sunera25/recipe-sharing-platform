package com.recipesharing.comment_service.service;

import com.recipesharing.comment_service.model.Comment;
import com.recipesharing.comment_service.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class CommentService {

    public static final Logger LOGGER = Logger.getLogger(CommentService.class.getName());
    private final CommentRepository commentRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public ResponseEntity<List<Comment>> getCommentsForRecipe(Long recipeId){
        try {
            List<Comment> comments = commentRepository.findByRecipeId(recipeId); //get comments based on recipe id
            if(comments.isEmpty()){
                LOGGER.warning("No comments found for recipe id " + recipeId);
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(comments);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE,"Error Retrieving coments for RecipeId"+ recipeId,e);
            return ResponseEntity.status(500).build();
        }
    }

    public ResponseEntity<Comment> addComment(Comment comment) {
        try {
            Comment savedComment = commentRepository.save(comment);
            return ResponseEntity.ok(savedComment);
        }catch (Exception e){
            LOGGER.log(Level.SEVERE,"Error Saving Comment",e);
            return ResponseEntity.status(500).build();
        }
    }
}
