package com.example.taskmanagement.controller;

import com.example.taskmanagement.dto.request.TaskRequestDto;
import com.example.taskmanagement.dto.response.TaskResponseDto;
import com.example.taskmanagement.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @PostMapping
    public ResponseEntity<TaskResponseDto> create(@RequestBody TaskRequestDto requestDto){
        return ResponseEntity.ok(taskService.create(requestDto));
    }

    @GetMapping
    public ResponseEntity<List<TaskResponseDto>> getAll() {
        return ResponseEntity.ok(taskService.gelAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskResponseDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(taskService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskResponseDto> update(
            @PathVariable Long id,
            @RequestBody TaskRequestDto request) {
        return ResponseEntity.ok(taskService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        taskService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
