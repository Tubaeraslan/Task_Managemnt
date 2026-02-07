package com.example.taskmanagement.service;

import com.example.taskmanagement.dto.request.TaskRequestDto;
import com.example.taskmanagement.dto.response.TaskResponseDto;

import java.util.List;

public interface TaskService {
    TaskResponseDto create(TaskRequestDto dto);

    List<TaskResponseDto> gelAll();

    TaskResponseDto getById(Long id);

    TaskResponseDto update(Long id,TaskRequestDto requestDto);

    void delete(Long id);
}
