package com.movieland.service.impl;

import com.movieland.dao.GenreDao;
import com.movieland.entity.Genre;
import com.movieland.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultGenreService implements GenreService {
    @Autowired
    GenreDao genreDao;

    @Override
    public List<Genre> getAllGenre() {
        return genreDao.getAllGenres();
    }
}
