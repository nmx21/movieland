package com.movieland.dao.jdbc;

import com.movieland.dao.GenreDao;
import com.movieland.dao.jdbc.mapper.GenreRowMapper;
import com.movieland.entity.Genre;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GenreDaoImpl implements GenreDao {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedJdbcTemplate;

    @Autowired
    private String getAllGenresSQL;

    @Override
    public List<Genre> getAllGenres() {
        log.info("Start query to get all genres from DB");
        long startTime = System.currentTimeMillis();
        List<Genre> genres = jdbcTemplate.query(getAllGenresSQL, new GenreRowMapper());
        log.info("Finish query to get random 3 movies from DB. It took {} ms", System.currentTimeMillis() - startTime);
        return genres;
    }


}
