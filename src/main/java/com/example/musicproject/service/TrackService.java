package com.example.musicproject.service;

import com.example.musicproject.model.dto.TrackDTO;
import com.example.musicproject.model.entity.Track;
import com.example.musicproject.model.mapper.TrackMapperStruct;
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

    private final TrackMapperStruct trackMapperStruct;


    public TrackDTO getTrack(Long id) {
        Track track = trackRepository.findById(id).orElseThrow(() -> new NoSuchElementException("There is no track with id: " + id));
        return trackMapperStruct.mapToTrackDTO(track);
    }

    public TrackDTO addTrack(TrackDTO trackDTO) {
        Track track = trackMapperStruct.mapToTrack(trackDTO);
        trackRepository.save(track);
        return trackMapperStruct.mapToTrackDTO(track);
    }
}