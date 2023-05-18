package com.example.jaz.service;

import com.example.jaz.exceptions.CustomBadRequestException;
import com.example.jaz.exceptions.CustomNotFoundException;
import com.example.jaz.model.Category;
import com.example.jaz.model.Movie;
import com.example.jaz.storage.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Optional<Movie> getMovieById(Long id) {
        Optional<Movie> movie = movieRepository.findById(id);
        if (movie.isPresent()) {
            return movie;
        }
        throw new CustomNotFoundException("No movie with such id found");
    }

    public List<Movie> getMovieList() {
        return movieRepository.findAll();
    }

    public Movie addNewMovie(Movie movie) {
        if (movie.getTitle() != null && movie.getCategory() != null) {
            if (Category.categoryExists(movie.getCategory().name())) {
                movieRepository.save(movie);
                return movie;
            }
        }
        throw new CustomBadRequestException("Given data not valid");
    }

    public Optional<Movie> updateMovie(Long id, Movie newMovie) {
        Optional<Movie> oldMovie = movieRepository.findById(id);
        if (oldMovie.isPresent()) {
//            Optional<Movie> newMovie = oldMovie.get();

        }
        throw new CustomNotFoundException("No movie with such id found");
    }

    public void deleteMovie(Long id) {
        if (movieRepository.findById(id).isPresent()) {
            movieRepository.deleteById(id);
        } else {
            throw new CustomNotFoundException("No movie with such id found");
        }
    }

    public Optional<Movie> refreshIsAvailable(Long id) {
        Optional<Movie> movie = movieRepository.findById(id);
        if (movie.isPresent()) {
            movie.get().setAvailable(true);
            movieRepository.save(movie);
            return movieRepository.findById(id);
        } else {
            throw new CustomNotFoundException("No movie with such id found");
        }
    }
}
