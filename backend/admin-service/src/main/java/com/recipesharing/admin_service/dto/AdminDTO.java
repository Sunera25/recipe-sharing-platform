package com.recipesharing.admin_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Valid
public class AdminDTO {

    @NotNull(message = "Name is required")
    @NotBlank(message = "Name can't be blank")
    private String name;

    @NotNull(message = "Password is required")
    @NotBlank(message = "Password can't be blank")
    private String password;
}
