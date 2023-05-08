package com.example.jaz.exceptions;

public class CustomNotFoundException extends RuntimeException {

    public CustomNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
