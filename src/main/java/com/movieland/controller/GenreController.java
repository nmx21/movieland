package com.movieland.controller;

import com.movieland.entity.Genre;
import com.movieland.service.GenreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/genre")
public class GenreController {
    private final Logger log = LoggerFactory.getLogger(getClass());
    @Autowired
    GenreService genreService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Genre> getAllGenre() {
        log.info("Sending request to get all genres");
        return genreService.getAllGenre();
    }
}
