package com.example.jaz.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

@ControllerAdvice
public class AdviceExceptionHandler {
    // Obsługa wyjątku HttpClientErrorException$NotFound
    @ExceptionHandler(HttpClientErrorException.NotFound.class)
    public ResponseEntity<String> handleNotFoundException(HttpClientErrorException.NotFound ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Exception from Rental handleNotFoundException method + Message: " + ex.getLocalizedMessage());
    }

    @ExceptionHandler(HttpServerErrorException.InternalServerError.class)
    public ResponseEntity<String> handleStatus500Exception(HttpServerErrorException.InternalServerError ex) {
        return ResponseEntity.status(HttpStatus.BAD_GATEWAY)
                .body("Exception from Rental handleStatus500Exception method + Message: " + ex.getLocalizedMessage());
    }

    @ExceptionHandler(HttpServerErrorException.ServiceUnavailable.class)
    public ResponseEntity<String> handleConnectException(HttpServerErrorException.ServiceUnavailable ex) {
        return ResponseEntity.status(HttpStatus.GATEWAY_TIMEOUT)
                .body("Exception from Rental handleConnectException method + Message: " + ex.getLocalizedMessage());
    }

    // Obsługa ogólna dla innych wyjątków
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGenericException(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Exception from Rental handleGenericException method + Massage: " + ex.getLocalizedMessage());
    }
}
