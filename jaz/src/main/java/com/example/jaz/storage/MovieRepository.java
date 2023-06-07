package com.example.jaz.storage;

import com.example.jaz.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MovieRepository extends JpaRepository<Movie, Long> {
//    @Query("SELECT m FROM Movie m where m.id = :id")
//    Optional<Movie> findById(Long id);
//
//    @Query("SELECT m FROM Movie m")
//    List<Movie> findAll();

//    @Override
//    <S extends Movie> S save(S entity);
//
//    @Override
//    void deleteAllById(Iterable<? extends Long> longs);

    //    Optional<Movie> findMovieByI
//    @Query("SELECT m FROM Movie m where m.id = :id SET ")
//    @Modifying
//    @Transactional
//    @Query("UPDATE Movie m set m.isAvailable = :isAvailable where m.id = :id")
//    void activateMovie(@Param(("active")) boolean isAvailable, @Param("id") Long id);

}
