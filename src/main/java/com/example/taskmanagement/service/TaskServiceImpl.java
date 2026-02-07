package com.example.taskmanagement.service;

import com.example.taskmanagement.dto.request.TaskRequestDto;
import com.example.taskmanagement.dto.response.TaskResponseDto;
import com.example.taskmanagement.entity.Task;
import com.example.taskmanagement.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService{

    private final TaskRepository taskRepository;

    @Override
    public TaskResponseDto create(TaskRequestDto dto) {
        Task task = new Task();
        task.setTitle(dto.getTitle());
        task.setDescription(dto.getDescription());

        Task saved = taskRepository.save(task);

        TaskResponseDto responseDto = new TaskResponseDto();
        responseDto.setId(saved.getId());
        responseDto.setTitle(saved.getTitle());
        responseDto.setDescription(saved.getDescription());

        return responseDto;
    }

    @Override
    public List<TaskResponseDto> getAll() {
        return taskRepository.findAll()
                .stream()
                .map(task -> {
                    TaskResponseDto dto = new TaskResponseDto();
                    dto.setId(task.getId());
                    dto.setTitle(task.getTitle());
                    dto.setDescription(task.getDescription());
                    return dto;
                })
                .toList();
    }

    @Override
    public TaskResponseDto getById(Long id) {
        Task task = taskRepository.findById(id).orElseThrow(()->
                new RuntimeException("Task not found"));

        TaskResponseDto dto=new TaskResponseDto();
        dto.setId(task.getId());
        dto.setTitle(task.getTitle());
        dto.setDescription(task.getDescription());
        return dto;
    }

    @Override
    public TaskResponseDto update(Long id, TaskRequestDto requestDto) {
        Task task = taskRepository.findById(id).orElseThrow(()->
                new RuntimeException("Task not found"));
        task.setTitle(requestDto.getTitle());
        task.setDescription(requestDto.getDescription());
        Task updated = taskRepository.save(task);

        TaskResponseDto dto=new TaskResponseDto();
        dto.setId(task.getId());
        dto.setTitle(task.getTitle());
        dto.setDescription(task.getDescription());
        return dto;
    }

    @Override
    public void delete(Long id) {
        taskRepository.deleteById(id);
    }
}
