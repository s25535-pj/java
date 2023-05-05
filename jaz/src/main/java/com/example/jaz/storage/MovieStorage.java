package com.example.jaz.storage;

import com.example.jaz.model.Movie;
import com.example.jaz.model.MovieCategory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MovieStorage {

    List<Movie> movieList;
    public MovieStorage(){
        this.movieList = List.of(
                new Movie(0,"W piochu i krzokach", MovieCategory.DRAMA),
                new Movie(1, "Nie ciulej franco", MovieCategory.COMEDY),
                new Movie(2, "Utopek: Dupno rajza", MovieCategory.ACTION)
        );
    }

    public List<Movie> getMovieList() {
        return movieList;
    }

    public Movie getMovieById(int id) {
        for (Movie movie : movieList) {
            if (movie.getId() == id){
                return movie;
            }
        }
        return null;
    }

    public Movie updateMovie(int id, Movie movie) {
        //Update movie method
        return movieList.get(id);
    }

    public void deleteMovie(int id) {
        //Remove movie method
    }
}
