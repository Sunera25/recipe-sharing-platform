package com.recipesharing.comment_service.model;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {

    @Id
    private ObjectId commentId;

    private Long recipeId;
    private String name;
    private String comment;
}
