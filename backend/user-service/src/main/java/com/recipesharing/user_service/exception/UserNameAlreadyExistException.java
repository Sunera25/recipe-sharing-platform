package com.recipesharing.user_service.exception;

public class UserNameAlreadyExistException extends RuntimeException {

    public UserNameAlreadyExistException(String message) {
        super(message);
    }
}
