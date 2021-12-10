package com.movieland.entity;

public class Movie {
    private Long id;
    private String movieNameRu;
    private String movieNameOriginal;
    private Byte yearId;
    private Double rating;
    private Double price;

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

    public Byte getYearId() {
        return yearId;
    }

    public void setYearId(Byte yearId) {
        this.yearId = yearId;
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
}
