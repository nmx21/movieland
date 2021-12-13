package com.movieland.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Movie {
    private Long id;
    @JsonProperty("nameRussian")
    private String movieNameRu;
    @JsonProperty("nameNative")
    private String movieNameOriginal;
    @JsonProperty("yearOfRelease")
    private Integer year;
    private Double rating;
    private Double price;
    @JsonProperty("picturePath")
    private String url;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMovieNameRu() {
        return movieNameRu;
    }

    public void setMovieNameRu(String movieNameRu) {
        this.movieNameRu = movieNameRu;
    }

    public String getMovieNameOriginal() {
        return movieNameOriginal;
    }

    public void setMovieNameOriginal(String movieNameOriginal) {
        this.movieNameOriginal = movieNameOriginal;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
