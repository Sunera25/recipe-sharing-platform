package com.recipesharing.comment_service.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Valid
public class CommentDTO {

    @NotNull(message = "RecipeId is required")
    private Long recipeId;

    @NotNull(message = "User ID is Required")
    private Long userId;

    @NotNull(message = "Name is Required")
    @NotBlank(message = "Name can't be a blank")
    private String name;

    @NotNull(message = "Comment is Required")
    @NotBlank(message = "Comment can't be a blank")
    private String comment;

}
