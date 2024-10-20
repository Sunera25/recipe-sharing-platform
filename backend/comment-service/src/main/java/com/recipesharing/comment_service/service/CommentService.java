package com.recipesharing.comment_service.service;

import com.recipesharing.comment_service.model.Comment;
import com.recipesharing.comment_service.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class CommentService {

    public static final Logger LOGGER = Logger.getLogger(CommentService.class.getName());
    private final CommentRepository commentRepository;


    @Autowired
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public List<Comment> getCommentsForRecipe(Long recipeId) {
        List<Comment> comments = commentRepository.findByRecipeId(recipeId); //get comments based on recipe id
        if (comments.isEmpty()) {
            LOGGER.warning("No comments found for recipe id " + recipeId);
            return null;
        }
        return comments;
    }

    public Comment addComment(Comment comment) {
        return commentRepository.save(comment);
    }
}
