package com.example.jaz.service;

import com.example.jaz.exceptions.CustomBadRequestException;
import com.example.jaz.exceptions.CustomNotFoundException;
import com.example.jaz.model.Movie;
import com.example.jaz.storage.MovieStorage;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    MovieStorage movieStorage;

    public MovieService(MovieStorage movieStorage) {
        this.movieStorage = movieStorage;
    }

    public Movie getMovieById(int id) {
        if (movieStorage.getMovieById(id) != null) {
            return movieStorage.getMovieById(id);
        }
        try {
            throw new CustomNotFoundException("No movie with such id found");
        } catch (CustomNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Movie> getMovieList() {
        return movieStorage.getMovieList();
    }

    public Movie addNewMovie(Movie movie) {
        if (movie.getTitle() != null && movie.getMovieCategory() != null) {
            // movieStorage.addNewMovie
            return movie;
        }
        try {
            throw new CustomBadRequestException("Given data not valid");
        } catch (CustomBadRequestException e) {
            throw new RuntimeException(e);
        }
    }

    public Movie updateMovie(int id, Movie movie) {
        if (movieStorage.getMovieById(id) != null) {
            return movieStorage.updateMovie(id, movie);
        }
        try {
            throw new CustomNotFoundException("No movie with such id found");
        } catch (CustomNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteMovie(int id) {
        if (movieStorage.getMovieById(id) != null) {
            movieStorage.deleteMovie(id);
        } else {
            try {
                throw new CustomNotFoundException("No movie with such id found");
            } catch (CustomNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
