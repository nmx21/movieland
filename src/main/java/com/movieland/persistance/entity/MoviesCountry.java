package com.movieland.persistance.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "MOVIES_COUNTRY")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)

public class MoviesCountry implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "movie_id")
    private Long movieId;
    @Column(name = "country_id")
    private Long countryId;

    @ManyToOne
    @JoinColumn(name = "movie_id", referencedColumnName = "id", updatable = false, insertable = false)
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "country_id", referencedColumnName = "id", updatable = false, insertable = false)
    private Country country;
}
