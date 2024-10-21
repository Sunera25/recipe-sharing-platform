package com.recipesharing.comment_service.exception;

public class MaximumCommentsException extends RuntimeException {
    public MaximumCommentsException(String message) {
        super(message);
    }
}
