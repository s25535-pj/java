package com.example.jaz.storage;

import com.example.jaz.model.Category;
import com.example.jaz.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface MovieRepository extends JpaRepository<Movie, Long> {
    @Query("SELECT m FROM Movie m where m.id = :id")
    Optional<Movie> findById(Long id);

    @Query("SELECT m FROM Movie m")
    List<Movie> findAll();

//    Optional<Movie> findMovieByI
//    @Query("SELECT m FROM Movie m where m.id = :id SET ")
//    @Modifying
//    @Query("UPDATE Movie m SET m.title = :title, m.category = :category where m.id = :id")
//    Optional<Movie> updateMovie(Long id, Movie movie);

}
