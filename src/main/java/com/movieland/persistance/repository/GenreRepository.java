package com.movieland.persistance.repository;

import com.movieland.persistance.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {
    @Query(value = "SELECT id, name FROM genre;", nativeQuery = true)
    public List<Genre> getAllGenre();

}
