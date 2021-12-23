package com.movieland.persistance.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "MOVIE")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Movie implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    //private String url;
    private String posterUrl;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "movie")
    @JsonIgnore
    List<MoviesCountry> moviesCountryList;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "movie")
    @JsonIgnore
    List<MoviesGenre> moviesGenreList;



}
