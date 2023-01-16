package com.example.musicproject.service;


import com.example.musicproject.model.dto.PerformerDTO;
import com.example.musicproject.model.entity.Performer;
import com.example.musicproject.model.mapper.PerformerMapper;
import com.example.musicproject.repository.PerformerRepository;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PerformerService {

    private final PerformerMapper performerMapper;

    private final PerformerRepository performerRepository;

    public Optional<Performer> getPerformerByName(String name) {
        return performerRepository.findByName(name);
    }

    public PerformerDTO addPerformer(@NotNull PerformerDTO performerDTO) {
        Performer performer = performerMapper.fromPerformerDTO(performerDTO);
        performerRepository.save(performer);
        return performerMapper.fromPerformer(performer);
    }

    public PerformerDTO getPerformer(Long id) {
        Performer performer = performerRepository.findById(id).orElseThrow(() -> new NoSuchElementException("There is no performer with id: " + id));
        return performerMapper.fromPerformer(performer);
    }

    public Performer createPerformer(String performerName) {
        PerformerDTO performerDTO = PerformerDTO.builder().name(performerName).build();
        Performer performer = performerMapper.fromPerformerDTO(performerDTO);
        performerRepository.save(performer);
        return performer;
    }
}
