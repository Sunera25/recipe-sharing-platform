package com.recipesharing.user_service.dto;

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
public class LoginDTO {

    @NotBlank(message = "Username can't be blank")
    @NotNull(message = "Username is required")
    private String userName;

    @NotBlank(message = "Password can't be bank")
    @NotNull(message = "Password is required")
    private String password;
}
