package com.recipesharing.comment_service.controller;

import com.recipesharing.comment_service.model.Comment;
import com.recipesharing.comment_service.service.CommentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {

    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/")
    public ResponseEntity<Comment> addComment(@Valid @RequestBody Comment comment) {
        Comment addedComment = commentService.addComment(comment);
        return ResponseEntity.ok(addedComment);
    }

    @GetMapping("/recipe/{recipeId}")
    public ResponseEntity<List<Comment>> getCommentsForRecipe(@PathVariable Long recipeId){
        List<Comment> comments = commentService.getCommentsForRecipe(recipeId);
        return ResponseEntity.ok(comments);
    }

}
