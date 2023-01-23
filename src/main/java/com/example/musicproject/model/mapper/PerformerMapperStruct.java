package com.example.musicproject.model.mapper;

import com.example.musicproject.model.dto.PerformerDTO;
import com.example.musicproject.model.entity.Performer;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;


@Mapper(componentModel = "spring",injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface PerformerMapperStruct {

    @Mapping(ignore = true,target="id")
    Performer mapToPerformer(PerformerDTO performerDTO);

    PerformerDTO mapToPerformerDTO(Performer performer);
}
