package com.recipesharing.user_service.service;

import com.recipesharing.user_service.dto.LoginDTO;
import com.recipesharing.user_service.dto.UserDTO;
import com.recipesharing.user_service.exception.UserNameAlreadyExistException;
import com.recipesharing.user_service.exception.WrongPasswordException;
import com.recipesharing.user_service.model.User;
import com.recipesharing.user_service.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public String createUser(UserDTO userDTO) {

        String encodedPassword = passwordEncoder.encode(userDTO.getPassword());

        User user = User.builder()
                .username(userDTO.getUsername())
                .password(encodedPassword)
                .email(userDTO.getEmail())
                .firstName(userDTO.getFirstName())
                .lastName(userDTO.getLastName())
                .phoneNumber(userDTO.getPhoneNumber())
                .build();

        userRepository.save(user);
        logger.info("User created");

        return ("Success");

    }


    public Boolean isUserNameAvailable(String userName) {
        Boolean isUserNameExist = userRepository.existsByUsername(userName);
        if (isUserNameExist) {
            logger.error("User name is not available");
            throw new UserNameAlreadyExistException("User name is not available");
        }
        return true;
    }

    public Long isPasswordMatch(LoginDTO loginDTO) {

        User user = userRepository.findByUsername(loginDTO.getUserName());
        String encodedPassword = passwordEncoder.encode(loginDTO.getPassword());

        if (!user.getPassword().equals(encodedPassword)) {
            logger.error("Password does not match");
            throw new WrongPasswordException("Password does not match");
        }
        logger.info("Password matched");
        return user.getUserId();
    }

}
