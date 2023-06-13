package com.example.jaz.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import org.springframework.lang.NonNull;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "This is movie id", maxLength = 1000, minLength = 6)
    private Long id;

    @Schema(description = "This is movie title", maxLength = 255, minLength = 3)
    private String title;

    @Enumerated(EnumType.STRING)
    @Schema(description = "This is movie category", example = "ACTION")

    private Category category;
    @NonNull
    @Schema(description = "This is if movie is avaliable")
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

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCategory(Category category) {
        this.category = category;
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
