package com.example.taskmanagement.service;

import com.example.taskmanagement.dto.request.TaskRequestDto;
import com.example.taskmanagement.dto.response.TaskResponseDto;
import com.example.taskmanagement.entity.Task;
import com.example.taskmanagement.exception.ResourceNotFoundException;
import com.example.taskmanagement.mapper.TaskMapper;
import com.example.taskmanagement.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService{

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    @Override
    public TaskResponseDto create(TaskRequestDto dto) {
        Task task = taskMapper.toEntity(dto);

        Task saved = taskRepository.save(task);

        return taskMapper.toDto(saved);
    }

    @Override
    public List<TaskResponseDto> getAll() {
        return taskRepository.findAll()
                .stream()
                .map(taskMapper::toDto)
                .toList();
    }

    @Override
    public TaskResponseDto getById(Long id) {
        Task task = taskRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Cannot found task"));

        return taskMapper.toDto(task);
    }

    @Override
    public TaskResponseDto update(Long id, TaskRequestDto requestDto) {
        Task task = taskRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Task cannot found"));
        task.setTitle(requestDto.getTitle());
        task.setDescription(requestDto.getDescription());
        Task updated = taskRepository.save(task);

        return taskMapper.toDto(updated);
    }

    @Override
    public void delete(Long id) {
        taskRepository.deleteById(id);
    }
}
