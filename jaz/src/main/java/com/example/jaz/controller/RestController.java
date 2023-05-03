package com.example.jaz.controller;

import com.example.jaz.model.Movie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
@RequestMapping("/movie")
public class RestController {

    @GetMapping("/getMovieList")
    public ResponseEntity<List<Movie>> returnMovieList(){
        return ResponseEntity.ok(List.of());
    }
}