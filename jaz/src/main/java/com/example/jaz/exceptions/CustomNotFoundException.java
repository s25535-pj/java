package com.example.jaz.exceptions;

public class CustomNotFoundException extends Exception {

    public CustomNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
