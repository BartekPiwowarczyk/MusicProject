package com.example.musicproject.controller;


import com.example.musicproject.model.dto.AlbumDTO;
import com.example.musicproject.model.dto.PerformerDTO;
import com.example.musicproject.model.dto.TrackDTO;
import com.example.musicproject.model.entity.Album;
import com.example.musicproject.model.entity.Performer;
import com.example.musicproject.model.entity.Track;
import com.example.musicproject.service.MusicService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MusicController {

    private MusicService musicService;

    public MusicController(MusicService albumService) {
        this.musicService = albumService;
    }

    @GetMapping("/albums")
    public ResponseEntity<List<AlbumDTO>> getListOfAlbums() {
        return ResponseEntity.ok().body(musicService.getListOfAlbums());
    }

    @GetMapping("/album/{id}")
    public ResponseEntity<AlbumDTO> getAlbumWithListOfTracks(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(musicService.getAlbum(id));
    }

    @GetMapping("/performer/{id}")
    public ResponseEntity<PerformerDTO> getPerformer(@PathVariable Long id) {
        return ResponseEntity.ok(musicService.getPerformer(id));
    }

    @GetMapping("/track/{id}")
    public ResponseEntity<TrackDTO> getTrack(@PathVariable Long id) {
        return ResponseEntity.ok(musicService.getTrack(id));
    }

    @PostMapping("/performer")
    public ResponseEntity<PerformerDTO> savePerformer(@Valid @RequestBody PerformerDTO performer) {
        return new ResponseEntity<>(musicService.addPerformer(performer), HttpStatus.CREATED);
    }

//    @PostMapping("/album")
//    public ResponseEntity<AlbumDTO> saveAlbum(@Valid @RequestBody AlbumDTO album) {
//        return new ResponseEntity<>(musicService.addAlbum(album), HttpStatus.CREATED);
//    }







}
