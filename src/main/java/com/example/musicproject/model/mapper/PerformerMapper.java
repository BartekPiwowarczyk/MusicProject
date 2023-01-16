package com.example.musicproject.model.mapper;

import com.example.musicproject.model.dto.PerformerDTO;
import com.example.musicproject.model.entity.Performer;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.NoSuchElementException;

@Component
public class PerformerMapper {

    public PerformerDTO fromPerformer(Performer performer) {
        return PerformerDTO.builder()
                .id(performer.getId())
                .name(performer.getName())
                .build();
    }

    public Performer fromPerformerDTO(@NotNull PerformerDTO performerDTO) throws NoSuchElementException {
        return Performer.builder()
                .name(performerDTO.getName())
                .albums(new HashSet<>())
                .tracks(new HashSet<>())
                .build();
    }
}
