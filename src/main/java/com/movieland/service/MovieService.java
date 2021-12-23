package com.movieland.service;

import com.movieland.persistance.entity.Movie;

import java.util.List;

public interface MovieService {
    Movie getById(long id);

    List<Movie> getRandomMovie();

    List getMovieByGenreId(long id);

    List<Movie> getMovieSort(String ratingTypeSort, String priceTypeSort);

}
