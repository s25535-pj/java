package com.example.jaz.storage;

import com.example.jaz.model.Category;
import com.example.jaz.model.Movie;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MovieStorage {

    List<Movie> movieList;
    public MovieStorage(){
        this.movieList = List.of(
                new Movie(0L,"W piochu i krzokach", Category.DRAMA),
                new Movie(1L, "Nie ciulej franco", Category.COMEDY),
                new Movie(2L, "Utopek: Dupno rajza", Category.ACTION)
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
