package com.movieland.persistance.repository;

import com.movieland.persistance.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    @Query(value = "SELECT id, movie_name_ru, movie_name_original, year, rating, price, poster_url FROM movie ORDER BY RAND() LIMIT 3", nativeQuery = true)
    public List<Movie> getRandomMovie();

    @Query(value = "SELECT m FROM Movie m WHERE id = ?1")
    public Optional<Movie> getMovieById(Long id);

    @Query(value = "SELECT movie.id, movie.movie_name_ru, movie.movie_name_original, movie.year, movie.rating, movie.price, movie.poster_url FROM movie INNER JOIN movies_genre ON movies_genre.movie_id = movie.id WHERE movies_genre.genre_id = ?1", nativeQuery = true)
    public List<Movie> getMovieByGenreId(Long id);
}
