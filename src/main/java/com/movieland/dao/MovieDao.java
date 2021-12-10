package com.movieland.dao;

import com.movieland.entity.Movie;

public interface MovieDao {
    Movie getById(long id);

    void add(Movie movie);
}
