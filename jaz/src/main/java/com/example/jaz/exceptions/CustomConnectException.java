package com.example.jaz.exceptions;

public class CustomConnectException extends RuntimeException{
    public CustomConnectException(String errorMessage) {
        super(errorMessage);
    }
}
