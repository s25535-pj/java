package com.example.jaz.exceptions;

public class CustomBadRequestException extends RuntimeException {

    public CustomBadRequestException(String errorMessage) {
        super(errorMessage);
    }
}
