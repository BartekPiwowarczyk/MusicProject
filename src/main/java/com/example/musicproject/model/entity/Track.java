package com.example.musicproject.model.entity;

import com.example.musicproject.model.entity.Album;
import com.example.musicproject.model.entity.Performer;
import jakarta.persistence.*;
import lombok.*;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Set;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Track {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="performer_id")
    private Performer performer;

    private int number;
    private String title;
    private LocalTime duration;

    @ManyToMany(mappedBy = "tracks")
    private Set<Album> albums;

}
