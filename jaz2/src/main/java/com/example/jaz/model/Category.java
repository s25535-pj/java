package com.example.jaz.model;

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
