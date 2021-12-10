package com.movieland.dao.jdbc.mapper;

import com.movieland.entity.Movie;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MovieRowMapper implements RowMapper<Movie> {
    @Override
    public Movie mapRow(ResultSet rs, int rowNum) throws SQLException {
        Movie movie = new Movie();
        movie.setId(rs.getLong("id"));
        movie.setMovieNameRu(rs.getString("movie_name_ru"));
        movie.setMovieNameOriginal(rs.getString("movie_name_original"));
        movie.setYearId(rs.getByte("year"));
        movie.setRating(rs.getDouble("rating"));
        movie.setPrice(rs.getDouble("price"));
        return movie;
    }
}
