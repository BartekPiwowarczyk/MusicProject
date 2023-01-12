package com.example.musicproject.service;


import com.example.musicproject.model.dto.AlbumDTO;
import com.example.musicproject.model.dto.PerformerDTO;
import com.example.musicproject.model.dto.TrackDTO;
import com.example.musicproject.model.entity.Album;
import com.example.musicproject.model.entity.Performer;
import com.example.musicproject.model.entity.Track;
import com.example.musicproject.model.mapper.AlbumMapper;
import com.example.musicproject.model.mapper.PerformerMapper;
import com.example.musicproject.model.mapper.TrackMapper;
import com.example.musicproject.repository.AlbumRepository;
import com.example.musicproject.repository.PerformerRepository;
import com.example.musicproject.repository.TrackRepository;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MusicService {

    private final AlbumRepository albumRepository;
    private final AlbumMapper albumMapper;
    private final PerformerRepository performerRepository;
    private final PerformerMapper performerMapper;

    private final TrackRepository trackRepository;

    private final TrackMapper trackMapper;


    public List<AlbumDTO> getListOfAlbums() {
        return albumRepository.findAll()
                .stream()
                .map(albumMapper::fromAlbum)
                .toList();
    }

    public AlbumDTO getAlbum(Long id) {
        Album album = albumRepository.findById(id).orElseThrow(() -> new NoSuchElementException("There is no album with id: " + id));
        return albumMapper.fromAlbum(album);
    }

    public PerformerDTO getPerformer(Long id) {
        Performer performer = performerRepository.findById(id).orElseThrow(() -> new NoSuchElementException("There is no performer with id: " + id));
        return performerMapper.fromPerformer(performer);
    }

    public TrackDTO getTrack(Long id) {
        Track track = trackRepository.findById(id).orElseThrow(() -> new NoSuchElementException("There is no track with id: " + id));
        return trackMapper.fromTrack(track);
    }

    public PerformerDTO addPerformer(@NotNull PerformerDTO performerDTO) {
        Performer performer = performerMapper.fromPerformerDTO(performerDTO);
        performerRepository.save(performer);
        return performerMapper.fromPerformer(performer);
    }

}
