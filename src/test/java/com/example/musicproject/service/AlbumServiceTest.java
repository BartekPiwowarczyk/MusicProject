package com.example.musicproject.service;

import com.example.musicproject.model.dto.AlbumDTO;
import com.example.musicproject.model.entity.Album;
import com.example.musicproject.model.entity.Performer;
import com.example.musicproject.model.entity.Track;
import com.example.musicproject.model.mapper.AlbumMapper;
import com.example.musicproject.repository.AlbumRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AlbumServiceTest {

    @Mock
    AlbumMapper albumMapper;
    @Mock
    private AlbumRepository albumRepository;

    @InjectMocks
    private AlbumService albumService;

    @Test
    void shouldGetAlbumById() {
        AlbumDTO albumDTO = AlbumDTO.builder()
                .id(1L)
                .title("title")
                .releaseDate(LocalDate.of(2000, 01, 02))
                .tracksNumberAndTitle(List.of("1. Track"))
                .performer("Performer")
                .build();
        Album album = new Album();
        album.setId(1L);
        album.setTitle("title");
        album.setReleaseDate(LocalDate.of(2000,01,02));
        Track track = new Track();
        track.setNumber(1);
        track.setTitle("Track");
        Performer performer = new Performer(1L,"Performer",null,null);
        track.setPerformer(performer);
        album.setTracks(Set.of(track));
        when(albumRepository.findById(anyLong())).thenReturn(Optional.of(album));
        when(albumMapper.fromAlbum(album)).thenReturn(albumDTO);


        AlbumDTO result = albumService.getAlbum(1L);
        assertEquals(1L,result.getId());
        assertEquals("title",result.getTitle());
        assertEquals(LocalDate.of(2000,01,02),result.getReleaseDate());
        assertEquals(List.of("1. Track"),result.getTracksNumberAndTitle());
        assertEquals("Performer",result.getPerformer());
    }

    @Test
    void shouldGetCorrectDuration() {
        Set<Track> tracks = Set.of();
        when(albumMapper.tracksDuration(tracks)).thenReturn(LocalTime.of(0,9,10));
        LocalTime expected = LocalTime.of(0,9,10);

        LocalTime result = albumMapper.tracksDuration(tracks);

        assertEquals(expected,result);
    }

    @Test
    void shouldThrowExceptionWhenAlbumNotExist() {
        assertThrows(NoSuchElementException.class, () -> {
            albumService.getAlbum(100L);
        }, "There is no album with id: 100");
    }

    @Test
    void shouldGetListOfAlbums() {
        Album album1 = new Album();
        album1.setId(1L);
        Album album2 = new Album();
        album1.setId(2L);
        Album album3 = new Album();
        album1.setId(3L);
        AlbumDTO albumDTO1 = AlbumDTO.builder().id(1L).build();
        AlbumDTO albumDTO2 = AlbumDTO.builder().id(1L).build();
        AlbumDTO albumDTO3 = AlbumDTO.builder().id(1L).build();
        when(albumRepository.findAll()).thenReturn(List.of(album1,album2,album3));
        when(albumMapper.fromAlbum(album1)).thenReturn(albumDTO1);
        when(albumMapper.fromAlbum(album2)).thenReturn(albumDTO2);
        when(albumMapper.fromAlbum(album3)).thenReturn(albumDTO3);

        List<AlbumDTO>  albums = albumService.getListOfAlbums();

        assertEquals(3,albums.size());
        assertEquals(albumDTO1,albums.get(0));
    }

}