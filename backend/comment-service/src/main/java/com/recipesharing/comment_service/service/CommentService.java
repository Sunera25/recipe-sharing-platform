package com.recipesharing.comment_service.service;

import com.recipesharing.comment_service.dto.CommentDTO;
import com.recipesharing.comment_service.exception.MaximumCommentsException;
import com.recipesharing.comment_service.model.Comment;
import com.recipesharing.comment_service.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


@Service
public class CommentService {

    public static final Logger LOGGER = LoggerFactory.getLogger(CommentService.class);
    private final CommentRepository commentRepository;


    @Autowired
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    //fetch comments based on recipe
    public List<Comment> getCommentsForRecipe(Long recipeId) {
        List<Comment> comments = commentRepository.findByRecipeId(recipeId); //get comments based on recipe id
        if (comments.isEmpty()) {
            LOGGER.warn("No comments found for recipe id {}", recipeId);
            return null;
        }
        return comments;
    }

    //save a comment for recipe
    public Comment createComment(CommentDTO commentDTO) {

        //One user can maximum add 10 comments
        if (commentRepository.countByRecipeIdAndUserId(commentDTO.getRecipeId(), commentDTO.getUserId()) > 10) {
            throw new MaximumCommentsException("Allowed Comment count is 10");
        }

        Comment newComment = Comment.builder()
                .comment(commentDTO.getComment())
                .name(commentDTO.getName())
                .recipeId(commentDTO.getRecipeId())
                .build();

        return commentRepository.save(newComment);
    }

}
