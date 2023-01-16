package com.example.musicproject.service;


import com.example.musicproject.model.dto.AlbumDTO;
import com.example.musicproject.model.dto.TrackDTO;
import com.example.musicproject.model.entity.Album;
import com.example.musicproject.model.entity.Track;
import com.example.musicproject.model.mapper.AlbumMapper;
import com.example.musicproject.model.mapper.TrackMapper;
import com.example.musicproject.repository.AlbumRepository;
import com.example.musicproject.repository.TrackRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class AlbumService {

    private final AlbumRepository albumRepository;
    private final AlbumMapper albumMapper;

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

    public  AlbumDTO  addAlbum(AlbumDTO albumDTO) {
        Album album = albumMapper.fromAlbumDTO(albumDTO);
        albumRepository.save(album);
        return albumMapper.fromAlbum(album);
    }
}
