package com.movieland.dao.jdbc;

import com.movieland.dao.MovieDao;
import com.movieland.dao.jdbc.mapper.MovieRowMapper;
import com.movieland.entity.Movie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class MovieDaoImpl implements MovieDao {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedJdbcTemplate;

    @Autowired
    private String getMovieByIdSQL;

    @Autowired
    private String addMovieSQL;

    @Override
    public Movie getById(long id) {
        log.info("Start query to get city with id {} from DB", id);
        long startTime = System.currentTimeMillis();
        Movie movie = jdbcTemplate.queryForObject(getMovieByIdSQL, new Object[]{id}, new MovieRowMapper());
        log.info("Finish query to get city with id {} from DB. It took {} ms", id, System.currentTimeMillis() - startTime);
        return movie;
    }

    @Override
    public void add(Movie movie) {
        log.info("Start query to add city {} to DB", movie);
        long startTime = System.currentTimeMillis();
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("movie_name_ru", movie.getMovieNameRu());
        parameterSource.addValue("movie_name_original", movie.getMovieNameOriginal());
        parameterSource.addValue("year", movie.getYearId());
        parameterSource.addValue("rating", movie.getRating());
        parameterSource.addValue("price", movie.getPrice());
        namedJdbcTemplate.update(addMovieSQL, parameterSource);
        log.info("Finish query to add city {} to DB. It took {} ms", movie, System.currentTimeMillis() - startTime);
    }

}