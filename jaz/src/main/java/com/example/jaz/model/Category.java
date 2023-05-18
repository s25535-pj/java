package com.example.jaz.model;

import com.example.jaz.exceptions.CustomNotFoundException;
import com.fasterxml.jackson.annotation.JsonCreator;

public enum Category {
    DRAMA, COMEDY, ACTION, HORROR;


    public static boolean categoryExists(String categoryName) {

        for (Category category: values()){
            if (category.name().equalsIgnoreCase(categoryName)){
                return true;
            }
        }
        return false;
    }
}
