package com.movieland.dao.jdbc.repository;

import com.movieland.dao.MovieDao;
import com.movieland.dao.jdbc.mapper.MovieRowMapper;
import com.movieland.entity.Movie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MovieDaoImplement implements MovieDao {
    private final Logger log = LoggerFactory.getLogger(getClass());
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private final static String GET_MOVIE_BY_ID_SQL = "SELECT id, movie_name_ru, movie_name_original, year, rating, price, url FROM movie LEFT JOIN movies_poster ON movies_poster.id_movie = movie.id WHERE id = ?;";
    private final static String GET_RANDOM_MOVIE_SQL = "SELECT id, movie_name_ru, movie_name_original, year, rating, price, url FROM movie LEFT JOIN movies_poster ON movies_poster.id_movie = movie.id ORDER BY RAND() LIMIT 3;";
    private final static String GET_MOVIE_BY_GENRE_SQL = "SELECT\n" +
            "                            id, movie_name_ru, movie_name_original, year, rating, price, url\n" +
            "                        FROM\n" +
            "                            movie\n" +
            "                        INNER JOIN\n" +
            "                            movies_genre\n" +
            "                        ON\n" +
            "                            movies_genre.movie_id = movie.id\n" +
            "                        LEFT JOIN\n" +
            "                            movies_poster\n" +
            "                        ON\n" +
            "                            movies_poster.id_movie = movie.id\n" +
            "                        WHERE movies_genre.genre_id = ? ;";


    @Override
    public Movie getById(long id) {
        log.info("Start query to get movie with id {} from DB", id);
        long startTime = System.currentTimeMillis();
        Movie movie = jdbcTemplate.queryForObject(GET_MOVIE_BY_ID_SQL, new Object[]{id}, new MovieRowMapper());
        log.info("Finish query to get movie with id {} from DB. It took {} ms", id, System.currentTimeMillis() - startTime);
        return movie;
    }

    @Override
    public List<Movie> getRandomMovie() {
        log.info("Start query to get random 3 movies from DB");
        long startTime = System.currentTimeMillis();
        List<Movie> movies = jdbcTemplate.query(GET_RANDOM_MOVIE_SQL, new MovieRowMapper());
        log.info("Finish query to get random 3 movies from DB. It took {} ms", System.currentTimeMillis() - startTime);
        return movies;
    }

    @Override
    public List<Movie> getMovieByGenreId(long id) {
        log.info("Start query to get movie by genre id from DB");
        long startTime = System.currentTimeMillis();
        List<Movie> movies = jdbcTemplate.query(GET_MOVIE_BY_GENRE_SQL, new MovieRowMapper(), id);
        log.info("Finish query to get movie by genre id  {} from DB. It took {} ms", id, System.currentTimeMillis() - startTime);
        return movies;

    }


}
