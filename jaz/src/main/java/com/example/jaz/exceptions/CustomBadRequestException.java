package com.example.jaz.exceptions;

public class CustomBadRequestException extends Exception {

    public CustomBadRequestException(String errorMessage) {
        super(errorMessage);
    }
}
