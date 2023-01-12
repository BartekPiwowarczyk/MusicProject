package com.example.musicproject.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

@Getter
@Setter
@Builder
public class TrackDTO {

    private Long id;
    private String title;
    private String performer;
    private int number;
    private LocalTime duration;
    private Set<String> albumsName;
}
