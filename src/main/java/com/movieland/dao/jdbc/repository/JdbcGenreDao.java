package com.movieland.dao.jdbc.repository;

import com.movieland.dao.GenreDao;
import com.movieland.dao.jdbc.mapper.GenreRowMapper;
import com.movieland.entity.Genre;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
    public class JdbcGenreDao implements GenreDao {
    private final Logger log = LoggerFactory.getLogger(getClass());
    private final static String GET_ALL_GENRES_SQL = "SELECT id, name FROM genre;";
    private final GenreRowMapper genreRowMapper = new GenreRowMapper();
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcGenreDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Genre> getAllGenres() {
        log.info("Start query to get all genres from DB");
        long startTime = System.currentTimeMillis();
        List<Genre> genres = jdbcTemplate.query(GET_ALL_GENRES_SQL, genreRowMapper);
        log.info("Finish query to get all genres from DB. It took {} ms", System.currentTimeMillis() - startTime);
        return genres;
    }
}
