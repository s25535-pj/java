package com.example.jaz.controller;

import com.example.jaz.model.Movie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@RestController
@RequestMapping()
public class RentalController {
    private final RestTemplate restTemplate;

    public RentalController(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @GetMapping("/rental/test")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok(restTemplate.getForObject(URI.create("http://localhost:8082/movies/test"), String.class));
    }

    @GetMapping("/rental/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable("id") Long id) {
        Movie movie = restTemplate.getForObject(URI.create("http://localhost:8082/movies/"+ id), Movie.class);
        return ResponseEntity.ok(movie);
    }

    @PostMapping("/rental")
    public ResponseEntity<Movie> addNewMovie(@RequestBody Movie movie) {
        ResponseEntity<Movie> response = restTemplate.postForEntity("http://localhost:8082/movies", movie, Movie.class);
        return ResponseEntity.ok(response.getBody());
    }

    @PutMapping("/rental/{id}/true")
    public ResponseEntity<Void> returnMovie(@PathVariable("id") Long id) {
        restTemplate.put(URI.create("http://localhost:8082/movies/"+ id + "/true"), Movie.class);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/rental/{id}/false")
    public ResponseEntity<Void> rentMovie(@PathVariable("id") Long id) {
        restTemplate.put(URI.create("http://localhost:8082/movies/"+ id + "/false"), Movie.class);
        return ResponseEntity.ok().build();
    }
}
