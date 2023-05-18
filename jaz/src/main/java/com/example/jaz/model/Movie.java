package com.example.jaz.model;

import jakarta.persistence.*;
import org.springframework.lang.NonNull;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @Enumerated(EnumType.STRING)
    private Category category;
    @NonNull
    private boolean isAvailable;

    public Movie() {
    }

    public Movie(Long id, String title, Category category) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.isAvailable = false;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Category getCategory() {
        return category;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
