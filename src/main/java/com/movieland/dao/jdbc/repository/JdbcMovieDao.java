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
public class JdbcMovieDao implements MovieDao {
    private final Logger log = LoggerFactory.getLogger(getClass());
    private final JdbcTemplate jdbcTemplate;
    private final static Integer DEF_COUNT_ROWS = 3;
    private final static String GET_MOVIE_BY_ID_SQL = "SELECT id, movie_name_ru, movie_name_original, year, rating, price, url FROM movie LEFT JOIN movies_poster ON movies_poster.id_movie = movie.id WHERE id = ?;";
    private final static String GET_RANDOM_MOVIE_SQL = "SELECT id, movie_name_ru, movie_name_original, year, rating, price, url FROM movie LEFT JOIN movies_poster ON movies_poster.id_movie = movie.id ORDER BY RAND() LIMIT " + DEF_COUNT_ROWS + ";";
    private final static String GET_MOVIE_BY_GENRE_SQL = "SELECT id, movie_name_ru, movie_name_original, year, rating, price, url FROM movie INNER JOIN movies_genre ON movies_genre.movie_id = movie.id LEFT JOIN movies_poster ON movies_poster.id_movie = movie.id WHERE movies_genre.genre_id = ? ;";
    private final static String GET_MOVIE_SORT = "SELECT id, movie_name_ru, movie_name_original, year, rating, price, url FROM movie LEFT JOIN movies_poster ON movies_poster.id_movie = movie.id";
    private final static String ORDER_BY = " ORDER BY ";
    private final static String PRICE = " price ";
    private final static String RATING = " rating ";
    private final static String DESC = "desc";
    private final MovieRowMapper movieRowMapper = new MovieRowMapper();

    @Autowired
    public JdbcMovieDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Movie getById(long id) {
        log.info("Start query to get movie with id {} from DB", id);
        long startTime = System.currentTimeMillis();
        Movie movie = jdbcTemplate.queryForObject(GET_MOVIE_BY_ID_SQL, movieRowMapper, id);
        log.info("Finish query to get movie with id {} from DB. It took {} ms", id, System.currentTimeMillis() - startTime);
        return movie;
    }

    @Override
    public List<Movie> getRandomMovie() {
        log.info("Start query to get random " + DEF_COUNT_ROWS + " movies from DB");
        long startTime = System.currentTimeMillis();
        List<Movie> movies = jdbcTemplate.query(GET_RANDOM_MOVIE_SQL, movieRowMapper);
        log.info("Finish query to get random " + DEF_COUNT_ROWS + " movies from DB. It took {} ms", System.currentTimeMillis() - startTime);
        return movies;
    }

    @Override
    public List<Movie> getMovieByGenreId(long id) {
        log.info("Start query to get movie by genre id from DB");
        long startTime = System.currentTimeMillis();
        List<Movie> movies = jdbcTemplate.query(GET_MOVIE_BY_GENRE_SQL, movieRowMapper, id);
        log.info("Finish query to get movie by genre id  {} from DB. It took {} ms", id, System.currentTimeMillis() - startTime);
        return movies;
    }

    @Override
    public List<Movie> getMovieSort(String ratingTypeSort, String priceTypeSort) {
        long startTime = System.currentTimeMillis();
        List<Movie> movies;
        String query = GET_MOVIE_SORT;
        if (ratingTypeSort != null || priceTypeSort != null) {
            query += ORDER_BY;
            if (ratingTypeSort != null) {
                query += " " + RATING;
                if (DESC.equalsIgnoreCase(ratingTypeSort)) {
                    query += DESC;
                }
                if (priceTypeSort != null) query += ",";
            }

            if (priceTypeSort != null) {
                query += PRICE;
                if (DESC.equalsIgnoreCase(priceTypeSort)) {
                    query += DESC;
                }
            }
        }
        movies = jdbcTemplate.query(query, movieRowMapper);
        log.info("Finish query to get movie sort field from DB. It took {} ms", System.currentTimeMillis() - startTime);
        return movies;
    }
}
