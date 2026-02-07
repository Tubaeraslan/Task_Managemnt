package com.example.taskmanagement.mapper;

import com.example.taskmanagement.dto.request.TaskRequestDto;
import com.example.taskmanagement.dto.response.TaskResponseDto;
import com.example.taskmanagement.entity.Task;

public interface TaskMapper {

    Task toEntity(TaskRequestDto dto);
    TaskResponseDto toDto(Task task);
}
