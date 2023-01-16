package com.example.musicproject.service;

import com.example.musicproject.model.dto.AlbumDTO;
import com.example.musicproject.model.entity.Track;
import com.example.musicproject.model.mapper.AlbumMapper;
import com.example.musicproject.repository.TrackRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalTime;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
public class AlbumServiceTestIntegration {

    @Autowired
    AlbumService albumService;

    @Autowired
    AlbumMapper albumMapper;

    @Autowired
    TrackRepository trackRepository;


    @Test
    void shouldGetAlbum() {
        AlbumDTO album = albumService.getAlbum(1L);

        assertEquals(1L,album.getId());
        System.out.println(album.getId());
    }

    @Test
    void shouldGetCorrectDuration() {
        Track track1 = trackRepository.findById(1L).get(); //2:45
//        track1.setDuration(LocalTime.of(0,5,40));
        Track track2 = trackRepository.findById(2L).get(); //2:20
//        track1.setDuration(LocalTime.of(0,3,50));
        Set<Track> tracks = Set.of(track1,track2);
        LocalTime expected = LocalTime.of(0,5,5);

        LocalTime result = albumMapper.tracksDuration(tracks);

        assertEquals(expected,result);
    }

    @Test
    void shouldGetAlbums() {

        List<String> expectedAlbums = List.of("1. track4", "2. track5");

        List<AlbumDTO> result =  albumService.getListOfAlbums();

        assertEquals(2, result.size());
        assertEquals(1,result.get(0).getId());
        assertEquals("Album2",result.get(1).getTitle());
        assertEquals(expectedAlbums,result.get(1).getTracksNumberAndTitle());
    }
}
