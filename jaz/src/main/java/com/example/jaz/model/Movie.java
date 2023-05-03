package com.example.jaz.model;

import org.springframework.stereotype.Service;


public class Movie {
    private String acrId;
    private String title;
    private MovieCategory movieCategory;

    public Movie(String acrId, String title, MovieCategory movieCategory) {
        this.acrId = acrId;
        this.title = title;
        this.movieCategory = movieCategory;
    }

    public String getAcrId() {
        return acrId;
    }

    public String getTitle() {
        return title;
    }

    public MovieCategory getMovieCategory() {
        return movieCategory;
    }
}


