package com.example.musicproject.model.mapper;

import com.example.musicproject.model.dto.TrackDTO;
import com.example.musicproject.model.entity.Track;
import com.example.musicproject.service.PerformerService;
import com.example.musicproject.service.TrackService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class TrackMapper {

   private final PerformerService performerService;
    public TrackDTO fromTrack(Track track) {
        return TrackDTO.builder()
                .id(track.getId())
                .title(track.getTitle())
                .duration(track.getDuration())
                .performer(track.getPerformer().getName())
                .number(track.getNumber())
                .albumsName(track.getAlbums().stream().map(album -> album.getTitle()).collect(Collectors.toSet()))
                .build();
    }

    public Track fromTrackDTO(TrackDTO trackDTO) {
        return Track.builder()
                .title(trackDTO.getTitle())
                .number(trackDTO.getNumber()) //edytować wstawianie numerów - nie przechowywać w bazie danych
                .duration(trackDTO.getDuration())
                .performer(performerService.getPerformerByName(trackDTO.getPerformer()).orElseGet(()->performerService.createPerformer(trackDTO.getPerformer())))
                .albums(new HashSet<>())
                .build();
    }
}
