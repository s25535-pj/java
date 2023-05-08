package com.example.jaz.model;

import com.example.jaz.exceptions.CustomNotFoundException;
import com.fasterxml.jackson.annotation.JsonCreator;

public enum MovieCategory {
    DRAMA, COMEDY, ACTION;


    public static boolean categoryExists(String categoryName) {

        for (MovieCategory movieCategory: values()){
            if (movieCategory.name().equalsIgnoreCase(categoryName)){
                return true;
            }
        }
        return false;
    }
}
