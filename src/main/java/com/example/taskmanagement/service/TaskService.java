package com.example.taskmanagement.service;

import com.example.taskmanagement.dto.request.TaskRequestDto;
import com.example.taskmanagement.dto.response.TaskResponseDto;

public interface TaskService {
    TaskResponseDto create(TaskRequestDto dto);
}
