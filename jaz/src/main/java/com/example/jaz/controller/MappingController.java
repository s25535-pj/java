package com.example.jaz.controller;

import com.example.jaz.model.Movie;
import com.example.jaz.service.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping()
public class MappingController {

    MovieService movieService;

    public MappingController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/movies")
    public ResponseEntity<List<Movie>> returnMovieList()  {
        return ResponseEntity.ok(movieService.getMovieList());
    }

    @GetMapping("/movies/{id}")
    public ResponseEntity<Optional<Movie>> returnMovieById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(movieService.getMovieById(id));
    }

    @GetMapping("/movies/{id}/true")
    public ResponseEntity<Optional<Movie>> changeMovieAvailability(@PathVariable("id") Long id) {
        return ResponseEntity.ok(movieService.changeIsAvailableToTrue(id));
    }

    @PostMapping("/movies")
    public ResponseEntity<Movie> addNewMovie(@RequestBody Movie movie) {
        return ResponseEntity.ok(movieService.addNewMovie(movie));
    }

    @PutMapping("/movies/{id}")
    public ResponseEntity<Optional<Movie>> updateMovie(@RequestBody Movie updatedMovie, @PathVariable("id") Long id) {
        return ResponseEntity.ok(movieService.updateMovie(id, updatedMovie));
    }

    @DeleteMapping("/movies/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable("id") Long id) {
        movieService.deleteMovie(id);
        return ResponseEntity.noContent().build();
    }
}