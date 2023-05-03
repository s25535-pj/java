package com.example.jaz.storage;

import com.example.jaz.model.Movie;
import com.example.jaz.model.MovieCategory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MovieStorage {

    List<Movie> movieList;
    public MovieStorage(List<Movie> movieList){
        this.movieList = List.of(
                new Movie("1","W piochu i krzokach", MovieCategory.DRAMA),
                new Movie("2", "Nie ciulej franco", MovieCategory.COMEDY),
                new Movie("3", "Utopek: Dupno rajza", MovieCategory.ACTION)
        );
    }

    public List<Movie> getMovieList() {
        return movieList;
    }

    public Movie getMovieById(String acrid) {
        for (Movie movie : movieList) {
            if (movie.getAcrId().equals(acrid)){
                return movie;
            }
        }
        return null;
    }
}
