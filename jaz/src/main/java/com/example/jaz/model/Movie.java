package com.example.jaz.model;

public class Movie {
    private int id;
    private String title;
    private MovieCategory movieCategory;

    public Movie(int id, String title, MovieCategory movieCategory) {
        this.id = id;
        this.title = title;
        this.movieCategory = movieCategory;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public MovieCategory getMovieCategory() {
        return movieCategory;
    }
}
