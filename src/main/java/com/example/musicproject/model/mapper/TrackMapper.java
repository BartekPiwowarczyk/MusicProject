package com.example.musicproject.model.mapper;

import com.example.musicproject.model.dto.TrackDTO;
import com.example.musicproject.model.entity.Track;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class TrackMapper {
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
}
