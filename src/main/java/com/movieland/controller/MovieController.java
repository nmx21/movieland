package com.movieland.controller;

import com.movieland.persistance.entity.Movie;
import com.movieland.service.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {
    private final Logger log = LoggerFactory.getLogger(getClass());
    @Autowired
    MovieService movieService;

    @GetMapping(path = "/{movieId}", produces = MediaType.APPLICATION_JSON_VALUE)
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

    @GetMapping(path = "/random", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Movie> getRandomMovie() {
        log.info("Sending request to get random movie ");
        return movieService.getRandomMovie();
    }

    @GetMapping(path = "/genre/{genreId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List getMovieByGenreId(@PathVariable("genreId") int genreId) {
        //List movie = new ArrayList();
        log.info("Sending request to get movie with genre id = {}", genreId);
        //movie = movieService.getMovieByGenreId(genreId);
        //        return movie;
        return movieService.getMovieByGenreId(genreId);
    }

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Movie> getMovieByRating(@RequestParam(name = "rating", required = false) String ratingTypeSort, @RequestParam(name = "price", required = false) String priceTypeSort) {
        List<Movie> movie = new ArrayList<>();
        log.info("Sending request to get movie sort by {} {}", ratingTypeSort, priceTypeSort);
        movie = movieService.getMovieSort(ratingTypeSort, priceTypeSort);
        return movie;
    }


}
