package com.example.taskmanagement.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskRequestDto {
    @NotBlank
    private String title;

    @NotBlank
    private String description;
}
