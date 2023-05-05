package com.example.jaz.controller;

import com.example.jaz.exceptions.CustomBadRequestException;
import com.example.jaz.exceptions.CustomNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class AdviceController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CustomNotFoundException.class)
    public ResponseEntity<String> noMovieIdException(CustomNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Exception: " + exception.getLocalizedMessage());
    }

    @ExceptionHandler(CustomBadRequestException.class)
    public ResponseEntity<String> dataNotValidException(CustomBadRequestException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Exception: " + exception.getLocalizedMessage());
    }
}
