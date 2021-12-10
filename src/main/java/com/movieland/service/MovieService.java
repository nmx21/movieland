package com.movieland.service;

import com.movieland.entity.Movie;

public interface MovieService {
    Movie getById(long id);

    void add(Movie movie);
}
