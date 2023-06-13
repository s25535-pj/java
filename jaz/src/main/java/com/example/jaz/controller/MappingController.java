package com.example.jaz.controller;

import com.example.jaz.model.Movie;
import com.example.jaz.service.MovieService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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


    @Operation(summary = "Test method to see if server is running")
    @GetMapping("/movies/test")
    public ResponseEntity<String> testMessage()  {
        return ResponseEntity.ok("test message from movie service");
    }

    @Operation(summary = "Get all movies as Object List")
    @GetMapping("/movies")
    public ResponseEntity<List<Movie>> returnMovieList()  {
        return ResponseEntity.ok(movieService.getMovieList());
    }

    @Operation(summary = "Get movie by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Film zwrócony pomyślnie"),
            @ApiResponse(responseCode = "404", description = "Filmu nie odnaleziono"), //content
            @ApiResponse(responseCode = "500", description = "Błąd servera")
    })
    @GetMapping("/movies/{id}")
    public ResponseEntity<Optional<Movie>> returnMovieById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(movieService.getMovieById(id));
    }

    @Operation(summary = "Set movie as avaliable, with choosen id")
    @PutMapping("/movies/{id}/true")
    public ResponseEntity<Optional<Movie>> changeMovieAvailabilityToTrue(@PathVariable("id") Long id) {
        return ResponseEntity.ok(movieService.changeIsAvailableToTrue(id));
    }

    @Operation(summary = "Set movie as unavaliable, with choosen id")
    @PutMapping("/movies/{id}/false")
    public ResponseEntity<Optional<Movie>> changeMovieAvailabilityToFalse(@PathVariable("id") Long id) {
        return ResponseEntity.ok(movieService.changeIsAvailableToFalse(id));
    }

    @Operation(summary = "Add new movie. You need to pass body with JSON")
    @PostMapping("/movies")
    public ResponseEntity<Movie> addNewMovie(@RequestBody Movie movie) {
        return ResponseEntity.ok(movieService.addNewMovie(movie));
    }


    @Operation(summary = "Update movie by id. You need to pass new movie body with JSON")
    @PutMapping("/movies/{id}")
    public ResponseEntity<Optional<Movie>> updateMovie(@RequestBody Movie updatedMovie, @PathVariable("id") Long id) {
        return ResponseEntity.ok(movieService.updateMovie(id, updatedMovie));
    }

    @Operation(summary = "Delete movie by id")
    @DeleteMapping("/movies/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable("id") Long id) {
        movieService.deleteMovie(id);
        return ResponseEntity.noContent().build();
    }
}