package com.example.taskmanagement.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskResponseDto {
    private Long id;
    private String title;
    private String description;
}
