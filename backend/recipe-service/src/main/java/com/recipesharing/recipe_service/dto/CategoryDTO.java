package com.recipesharing.recipe_service.dto;

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
public class CategoryDTO {

    @NotNull(message = "Category name required")
    @NotBlank(message = "Category name can't be blank")
    private String categoryName;

    private String imageUrl;
}
