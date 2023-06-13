package com.example.jaz.model;

import io.swagger.v3.oas.annotations.media.Schema;
@Schema(description = "These are movie categories")

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
