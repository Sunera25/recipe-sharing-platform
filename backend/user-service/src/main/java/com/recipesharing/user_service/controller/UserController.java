package com.recipesharing.user_service.controller;

import com.recipesharing.user_service.dto.LoginDTO;
import com.recipesharing.user_service.dto.UserDTO;
import com.recipesharing.user_service.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> createUser(@Valid @RequestBody UserDTO userDTO) {
        String message = userService.createUser(userDTO);
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    @GetMapping("/{userName}")
    public ResponseEntity<Boolean> isUserNameAvailable(@PathVariable String userName) {
        Boolean userAvailability = userService.isUserNameAvailable(userName);
        return new ResponseEntity<>(userAvailability, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<Long> loginUser(@Valid @RequestBody LoginDTO loginDTO) {
        Long userId = userService.isPasswordMatch(loginDTO);
        return new ResponseEntity<>(userId, HttpStatus.OK);
    }


}
