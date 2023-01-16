package com.example.musicproject.service;

import com.example.musicproject.model.dto.TrackDTO;
import com.example.musicproject.model.entity.Album;
import com.example.musicproject.model.entity.Track;
import com.example.musicproject.model.mapper.TrackMapper;
import com.example.musicproject.repository.AlbumRepository;
import com.example.musicproject.repository.TrackRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class TrackService {
    private final AlbumRepository albumRepository;

    private final TrackRepository trackRepository;
    private final TrackMapper trackMapper;

    public TrackDTO getTrack(Long id) {
        Track track = trackRepository.findById(id).orElseThrow(() -> new NoSuchElementException("There is no track with id: " + id));
        return trackMapper.fromTrack(track);
    }

    public TrackDTO addTrack(TrackDTO trackDTO) {
        Track track = trackMapper.fromTrackDTO(trackDTO);
        for (String element : trackDTO.getAlbumsName()) {
            Album albumToSearch = albumRepository.findByTitle(element).orElse(null);
            if (albumToSearch == null) {
                Album albumToSave = Album.builder().title(element).build();
                albumRepository.save(albumToSave);
                track.getAlbums().add(albumToSave);
            } else {
                track.getAlbums().add(albumToSearch);
            }
        }
        trackRepository.save(track);
        return trackMapper.fromTrack(track);
    }
}