package com.example.jaz.service;

import com.example.jaz.model.Movie;
import com.example.jaz.model.MovieCategory;
import com.example.jaz.storage.MovieStorage;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {

    MovieStorage movieStorage;
    public MovieService(MovieStorage movieStorage){
        this.movieStorage = movieStorage;
    }

    public String throwNoMovieIdExeption(){
        throw new RuntimeException("No movie with such id found");
    }

    public Movie getMovieById(String acrid){
        return movieStorage.getMovieById(acrid);
    }

    public List<Movie> getMovieList(){
        return movieStorage.getMovieList();
    }
}
