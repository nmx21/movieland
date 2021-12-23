package com.movieland.persistance.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "MOVIES_REVIEWS")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)

public class MoviesReviews {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "id_movie")
    private Long idMovie;
    @Column(name = "id_user")
    private Long idUser;
    private String review;

    @ManyToOne
    @JoinColumn(name = "id_movie", referencedColumnName = "id", updatable = false,insertable = false)
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "id_user", referencedColumnName = "id", updatable = false,insertable = false)
    private Country country;

}
