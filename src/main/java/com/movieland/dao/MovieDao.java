package com.movieland.dao;

import com.movieland.entity.Movie;

import java.util.List;

public interface MovieDao {
    Movie getById(long id);

    void add(Movie movie);

    List<Movie> getRandomMovie();
}
