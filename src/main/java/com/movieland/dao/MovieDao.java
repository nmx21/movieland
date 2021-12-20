package com.movieland.dao;

import com.movieland.entity.Movie;

import java.util.List;

public interface MovieDao {
    Movie getById(long id);

    List<Movie> getRandomMovie();

    List<Movie> getMovieByGenreId(long id);

    List<Movie> getMovieSort(String ratingTypeSort,String priceTypeSort);
}
