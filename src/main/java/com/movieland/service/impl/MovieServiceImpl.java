package com.movieland.service.impl;

import com.movieland.persistance.entity.Movie;
import com.movieland.persistance.repository.MovieRepository;
import com.movieland.service.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class MovieServiceImpl implements MovieService {
    private final static String DESC = "desc";

    @Autowired
    MovieRepository movieRepository;

    @Override
    public Movie getById(long id) {
        return movieRepository.getMovieById(id).orElse(null);
    }

    @Override
    public List<Movie> getRandomMovie() {
        return movieRepository.getRandomMovie();
    }

    @Override
    public List<Movie> getMovieByGenreId(long id) {
        return movieRepository.getMovieByGenreId(id);
    }

    @Override
    public List<Movie> getMovieSort(String ratingTypeSort, String priceTypeSort) {
        List<Movie> movieList = movieRepository.findAll();
        if (ratingTypeSort != null || priceTypeSort != null) {
            if (ratingTypeSort != null) {
                if (priceTypeSort != null) {
                    return orderByRatingAndPrice(movieList, ratingTypeSort, priceTypeSort);
                }
                return orderByRating(movieList, ratingTypeSort);
            }
            return orderByPrice(movieList, priceTypeSort);
        }
        return movieList;
    }

    private List<Movie> orderByRating(List<Movie> movieList, String orderType) {
        if (DESC.equalsIgnoreCase(orderType)) {
            return movieList.stream().sorted(Comparator.comparing(Movie::getRating, Comparator.reverseOrder())).collect(Collectors.toList());
        }
        return movieList.stream().sorted(Comparator.comparing(Movie::getRating)).collect(Collectors.toList());
    }

    private List<Movie> orderByPrice(List<Movie> movieList, String orderType) {
        if (DESC.equalsIgnoreCase(orderType)) {
            return movieList.stream().sorted(Comparator.comparing(Movie::getPrice, Comparator.reverseOrder())).collect(Collectors.toList());
        }
        return movieList.stream().sorted(Comparator.comparing(Movie::getPrice)).collect(Collectors.toList());
    }

    private List<Movie> orderByRatingAndPrice(List<Movie> movieList, String ratingTypeSort, String priceTypeSort) {
        if (DESC.equalsIgnoreCase(ratingTypeSort)) {
            if (DESC.equalsIgnoreCase(priceTypeSort)) {
                return movieList.stream().sorted(Comparator.comparing(Movie::getRating, Comparator.reverseOrder()).thenComparing(Movie::getPrice, Comparator.reverseOrder())).collect(Collectors.toList());
            }
            return movieList.stream().sorted(Comparator.comparing(Movie::getRating, Comparator.reverseOrder()).thenComparing(Movie::getPrice)).collect(Collectors.toList());
        } else if (DESC.equalsIgnoreCase(priceTypeSort)) {
            return movieList.stream().sorted(Comparator.comparing(Movie::getRating).thenComparing(Movie::getPrice, Comparator.reverseOrder())).collect(Collectors.toList());
        }
        return movieList.stream().sorted(Comparator.comparing(Movie::getRating).thenComparing(Movie::getPrice)).collect(Collectors.toList());
    }
}
