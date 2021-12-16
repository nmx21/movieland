package com.movieland.service.impl;

import com.movieland.dao.MovieDao;
import com.movieland.entity.Movie;
import com.movieland.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImplement implements MovieService {
    @Autowired
    MovieDao movieDao;

    @Override
    public Movie getById(long id) {
        return movieDao.getById(id);
    }

    @Override
    public List<Movie> getRandomMovie() {
        return movieDao.getRandomMovie();
    }

    @Override
    public List<Movie> getMovieByGenreId(long id) {
        return movieDao.getMovieByGenreId(id);
    }
}
