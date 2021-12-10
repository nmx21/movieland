package com.movieland.controller;

import com.movieland.entity.Movie;
import com.movieland.service.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api/v1/movie")
public class MovieController {
    private final Logger log = LoggerFactory.getLogger(getClass());
    @Autowired
    MovieService movieService;

    @RequestMapping(method = RequestMethod.GET, name = "/{movieId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Movie getMovieById(@PathVariable("movieID") int movieId) {
        log.info("Sending request to get movie with id = {}", movieId);
        return movieService.getById(movieId);
    }
}
