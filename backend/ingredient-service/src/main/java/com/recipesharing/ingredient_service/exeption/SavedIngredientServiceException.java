package com.recipesharing.ingredient_service.exeption;

public class SavedIngredientServiceException extends RuntimeException {
    public SavedIngredientServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
