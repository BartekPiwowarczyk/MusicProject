package com.example.musicproject.controller;


import com.example.musicproject.model.dto.AlbumDTO;
import com.example.musicproject.model.dto.PerformerDTO;
import com.example.musicproject.model.dto.TrackDTO;
import com.example.musicproject.service.AlbumService;
import com.example.musicproject.service.PerformerService;
import com.example.musicproject.service.TrackService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MusicController {

    private final AlbumService albumService;
    private final PerformerService performerService;
    private  final TrackService trackService;

    public MusicController(AlbumService albumService, PerformerService performerService, TrackService trackService) {
        this.albumService = albumService;
        this.performerService = performerService;
        this.trackService = trackService;
    }

    @GetMapping("/albums")
    public ResponseEntity<List<AlbumDTO>> getListOfAlbums() {
        return ResponseEntity.ok().body(albumService.getListOfAlbums());
    }

    @GetMapping("/album/{id}")
    public ResponseEntity<AlbumDTO> getAlbumWithListOfTracks(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(albumService.getAlbum(id));
    }

    @GetMapping("/performer/{id}")
    public ResponseEntity<PerformerDTO> getPerformer(@PathVariable Long id) {
        return ResponseEntity.ok(performerService.getPerformer(id));
    }

    @GetMapping("/track/{id}")
    public ResponseEntity<TrackDTO> getTrack(@PathVariable Long id) {
        return ResponseEntity.ok(trackService.getTrack(id));
    }

    @PostMapping("/performer")
    public ResponseEntity<PerformerDTO> savePerformer(@Valid @RequestBody PerformerDTO performer) {
        return new ResponseEntity<>(performerService.addPerformer(performer), HttpStatus.CREATED);
    }

    @PostMapping("/album")
    public ResponseEntity<AlbumDTO> saveAlbum(@Valid @RequestBody AlbumDTO album) {
        return new ResponseEntity<>(albumService.addAlbum(album), HttpStatus.CREATED);
    }

    @PostMapping("/track")
    public ResponseEntity<TrackDTO> saveAlbum(@Valid @RequestBody TrackDTO track) {
        return new ResponseEntity<>(trackService.addTrack(track), HttpStatus.CREATED);
    }





}
