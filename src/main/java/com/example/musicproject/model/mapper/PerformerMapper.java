package com.example.musicproject.model.mapper;

import com.example.musicproject.model.dto.PerformerDTO;
import com.example.musicproject.model.entity.Performer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashSet;

@Component
public class PerformerMapper {

    public PerformerDTO fromPerformer(Performer performer) {
        return PerformerDTO.builder()
                .id(performer.getId())
                .name(performer.getName())
                .build();
    }

    public Performer fromPerformerDTO(PerformerDTO performerDTO) {
        return Performer.builder()
                .name(performerDTO.getName())
                .albums(new HashSet<>())
                .tracks(new HashSet<>())
                .build();
    }
}
