package com.movieland.service;

import com.movieland.entity.Movie;

import java.util.List;

public interface MovieService {
    Movie getById(long id);

    List<Movie> getRandomMovie();

    List<Movie> getMovieByGenreId(long id);

    List<Movie> getMovieSort(String ratingTypeSort, String priceTypeSort);

}
