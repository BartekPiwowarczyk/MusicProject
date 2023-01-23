package com.example.musicproject.service;


import com.example.musicproject.model.dto.AlbumDTO;
import com.example.musicproject.model.entity.Album;
import com.example.musicproject.model.mapper.AlbumMapper;
import com.example.musicproject.repository.AlbumRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AlbumService {

    private final AlbumRepository albumRepository;
    private final AlbumMapper albumMapper;

    public List<AlbumDTO> getListOfAlbumsDTO() {
        return albumRepository.findAll()
                .stream()
                .map(albumMapper::fromAlbum)
                .collect(Collectors.toList());
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

    public Set<Album> getSetOfAlbums (Set<String> albumsName) {
        Set<Album> albumsForTrack = new HashSet<>();
        for (String albumTitle : albumsName){
            albumsForTrack.add(albumRepository.findByTitle(albumTitle).orElseThrow(() -> new NoSuchElementException("First you must add Album to Repository " + albumTitle)));
        }
        return albumsForTrack;

    }

}
