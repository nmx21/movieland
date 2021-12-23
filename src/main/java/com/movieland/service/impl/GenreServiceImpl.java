package com.movieland.service.impl;

import com.movieland.persistance.entity.Genre;
import com.movieland.persistance.repository.GenreRepository;
import com.movieland.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {

    @Autowired
    GenreRepository genreRepository;

    @Override
    public List<Genre> getAllGenre() {
        return genreRepository.getAllGenre();
    }
}
