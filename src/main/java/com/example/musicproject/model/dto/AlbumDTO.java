package com.example.musicproject.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Builder
public class AlbumDTO {

    private Long id;
    private String title;
    private String performer;
    private LocalDate releaseDate;
    private LocalTime duration;
    private List<String> tracksNumberAndTitle;

}
