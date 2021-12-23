package com.movieland.persistance.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "MOVIES_GENRE")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class MoviesGenre implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "movie_id")
    private Long movieId;
    @Column(name = "genre_id")
    private Long genreId;

    @ManyToOne
    @JoinColumn(name = "movie_id", referencedColumnName = "id", updatable = false, insertable = false)
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "genre_id", referencedColumnName = "id", updatable = false, insertable = false)
    private Genre genre;
}
