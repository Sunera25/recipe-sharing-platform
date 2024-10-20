package com.recipesharing.comment_service.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
@Valid
public class Comment {

    @Id
    private ObjectId commentId;

    @NotNull(message = "RecipeId is required")
    private Long recipeId;

    @NotNull(message = "Name is Required")
    @NotBlank(message = "Name can't be a blank")
    private String name;

    @NotNull(message = "Comment is Required")
    @NotBlank(message = "Comment can't be a blank")
    private String comment;
}
