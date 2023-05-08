package com.example.jaz.service;

import com.example.jaz.exceptions.CustomBadRequestException;
import com.example.jaz.exceptions.CustomNotFoundException;
import com.example.jaz.model.Movie;
import com.example.jaz.model.MovieCategory;
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
            throw new CustomNotFoundException("No movie with such id found");
    }

    public List<Movie> getMovieList() {
        return movieStorage.getMovieList();
    }

    public Movie addNewMovie(Movie movie) {
        System.out.println(movie.getMovieCategory().name());
        if (movie.getTitle() != null && movie.getMovieCategory() != null) {
            if (MovieCategory.categoryExists(movie.getMovieCategory().name())) {
                // movieStorage.addNewMovie
                return movie;
            }
        }
        throw new CustomBadRequestException("Given data not valid");
    }

    public Movie updateMovie(int id, Movie movie) {
        if (movieStorage.getMovieById(id) != null) {
            return movieStorage.updateMovie(id, movie);
        }
            throw new CustomNotFoundException("No movie with such id found");
    }

    public void deleteMovie(int id) {
        if (movieStorage.getMovieById(id) != null) {
            movieStorage.deleteMovie(id);
        } else {
                throw new CustomNotFoundException("No movie with such id found");
        }
    }
}
