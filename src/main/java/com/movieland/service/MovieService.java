package com.movieland.service;

import com.movieland.entity.Movie;
import java.util.List;

public interface MovieService {
    Movie getById(long id);

    void add(Movie movie);

    List<Movie> getRandomMovie();
}
