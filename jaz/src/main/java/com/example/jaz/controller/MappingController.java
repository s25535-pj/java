package com.example.jaz.controller;

import com.example.jaz.model.Movie;
import com.example.jaz.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RestController
@RequestMapping()
public class MappingController {

    MovieService movieService;
    public MappingController(MovieService movieService){
        this.movieService = movieService;
    }

    @GetMapping("/movies")
    public ResponseEntity<List<Movie>> returnMovieList(){
        return ResponseEntity.ok(movieService.getMovieList());
    }

    @GetMapping("/movies/{id}")
    public ResponseEntity<Movie> returnMovieById(@PathVariable("id") String movieId){
        if(movieService.getMovieById(movieId) == null){
            String exceptionMassage = movieService.throwNoMovieIdExeption();
        }
        return ResponseEntity.ok(movieService.getMovieById(movieId));
    }
}