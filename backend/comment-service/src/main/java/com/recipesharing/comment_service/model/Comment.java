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
@Builder
public class Comment {

    @Id
    private ObjectId commentId;

    private Long recipeId;
    private String name;
    private Long userId;
    private String comment;
}
