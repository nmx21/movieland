package com.movieland.dao;

import com.movieland.entity.Genre;
import com.movieland.entity.Movie;

import java.util.List;

public interface GenreDao {

    List<Genre> getAllGenres();

}