package com.example.jaz.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AdviceController {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> throwNoMovieIdExeption(RuntimeException exception){
        return  ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Exception: " + exception.getLocalizedMessage());
    }
}
