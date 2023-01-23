package com.example.musicproject.model.mapper;


import com.example.musicproject.model.dto.PerformerDTO;
import com.example.musicproject.model.dto.TrackDTO;
import com.example.musicproject.model.entity.Album;
import com.example.musicproject.model.entity.Performer;
import com.example.musicproject.model.entity.Track;
import com.example.musicproject.service.AlbumService;
import com.example.musicproject.service.PerformerService;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(uses={AlbumMapper.class}, componentModel = "spring",injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public abstract class TrackMapperStruct {

    @Autowired
    protected PerformerService performerService;

    @Autowired
    protected AlbumService albumService;

    @Mapping(ignore = true,target = "id")
    @Mapping(target = "performer",expression =
            "java(performerService.getOrCreatePerformer(trackDTO.getPerformer()))")
    @Mapping(target="albums", expression =
            "java(albumService.getSetOfAlbums(trackDTO.getAlbumsName()))")
    public abstract Track mapToTrack(TrackDTO trackDTO);



    @Mapping(source = "performer.name",target="performer")
    @Mapping(target="albumsName", expression = "java(TrackMapperStruct.albumsToAlbumsName(track))")
    public abstract TrackDTO mapToTrackDTO(Track track);

    protected static Set<String> albumsToAlbumsName(Track track) {
        return track.getAlbums().stream().map(Album::getTitle).collect(Collectors.toSet());
    }

}
