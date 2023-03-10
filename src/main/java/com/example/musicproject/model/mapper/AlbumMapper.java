package com.example.musicproject.model.mapper;

import com.example.musicproject.model.dto.AlbumDTO;
import com.example.musicproject.model.entity.Album;
import com.example.musicproject.model.entity.Track;
import com.example.musicproject.service.PerformerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class AlbumMapper {

    private final PerformerService performerService;
    public Album fromAlbumDTO(AlbumDTO albumDTO) {
        return Album.builder()
                .title(albumDTO.getTitle())
                .performer(performerService.getPerformerByName(albumDTO.getPerformer()).orElseGet(()->performerService.createPerformer(albumDTO.getPerformer())))
                .releaseDate(albumDTO.getReleaseDate())
                .tracks(new HashSet<>())
                .build();
    }

    public AlbumDTO fromAlbum(Album album) {
        return AlbumDTO.builder()
                .id(album.getId())
                .title(album.getTitle())
                .releaseDate(album.getReleaseDate())
                .performer(album.getPerformer().getName())
                .duration(tracksDuration(album.getTracks()))
                .tracksNumberAndTitle(getSortedTracks(album.getTracks()))
                .build();
    }

    public List<String> getSortedTracks(Set<Track> tracks) {
        return tracks.stream()
                .sorted(Comparator.comparingInt(Track::getNumber))
                .map(track ->track.getNumber() + ". " + track.getTitle())
                .collect(Collectors.toList());

    }

    public LocalTime tracksDuration(Set<Track> tracks) {
        LocalTime duration = LocalTime.of(0, 0, 0);

        for (Track element:tracks) {
           duration = duration.plusHours(element.getDuration().getHour());
            duration = duration.plusMinutes(element.getDuration().getMinute());
            duration = duration.plusSeconds(element.getDuration().getSecond());
        };
        return duration ;
    }


}
