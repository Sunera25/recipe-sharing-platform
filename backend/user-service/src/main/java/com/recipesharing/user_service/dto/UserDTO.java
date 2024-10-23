package com.recipesharing.user_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Valid
public class UserDTO {

    @NotBlank(message = "Username can't be blank")
    @NotNull(message = "Username is required")
    private String username;

    @NotBlank(message = "First Name can't be blank")
    @NotNull(message = "First Name is required")
    private String firstName;

    @NotBlank(message = "Last Name can't be blank")
    @NotNull(message = "Last Name is required")
    private String lastName;

    @NotNull(message = "Password is required")
    @NotBlank(message = "Password can't be blank")
    private String password;

    @NotBlank(message = "Phone Number can't be blank")
    @NotNull(message = "Phone Number is required")
    private String phoneNumber;

    @NotNull(message = "Email is required")
    @NotBlank(message = "Email can't be blank")
    private String email;
}
