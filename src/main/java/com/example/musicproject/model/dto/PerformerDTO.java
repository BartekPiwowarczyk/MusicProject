package com.example.musicproject.model.dto;


import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class PerformerDTO {

    @Positive
    private Long id;
    private String name;
}
