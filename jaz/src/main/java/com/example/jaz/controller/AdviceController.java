package com.example.jaz.controller;

import com.example.jaz.exceptions.CustomBadRequestException;
import com.example.jaz.exceptions.CustomConnectException;
import com.example.jaz.exceptions.CustomNotFoundException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.ConnectException;

@RestControllerAdvice

public class AdviceController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CustomNotFoundException.class)
    public ResponseEntity<String> noMovieIdException(CustomNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("noMovieIdException: " + ex.getLocalizedMessage());
    }

    @ExceptionHandler(CustomBadRequestException.class)
    public ResponseEntity<String> dataNotValidException(CustomBadRequestException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("dataNotValidException: " + ex.getLocalizedMessage());
    }

//    @ExceptionHandler(CustomConnectException.class)
//    public ResponseEntity<String> handleConnectException(CustomConnectException ex) {
//        return ResponseEntity.BodyBuilder
//                .body("handleConnectException: " + ex.getLocalizedMessage());
//    }
}
