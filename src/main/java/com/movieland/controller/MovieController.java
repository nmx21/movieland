package com.movieland.controller;

import com.movieland.entity.Movie;
import com.movieland.service.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

@Controller
@RequestMapping("/api/v1/movie")
public class MovieController {
    private final Logger log = LoggerFactory.getLogger(getClass());
    @Autowired
    MovieService movieService;

    @RequestMapping(method = RequestMethod.GET, path = "/{movieId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Movie> getMovieById(@PathVariable("movieId") int movieId) {
        Movie movie = null;
        log.info("Sending request to get movie with id = {}", movieId);
        try {
            movie = movieService.getById(movieId);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return ResponseEntity.badRequest().body(movie);
        }
        return ResponseEntity.ok(movie);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/random", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Movie> getRandomMovie() {
        log.info("Sending request to get random movie ");
        return movieService.getRandomMovie();
    }
}
