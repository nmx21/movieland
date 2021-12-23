package com.movieland.persistance.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "MOVIES_DESCRIPTION")
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MoviesDescription {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "movie_id")
    private Long movieId;
    @Column(name = "description")
    private String description;
}
