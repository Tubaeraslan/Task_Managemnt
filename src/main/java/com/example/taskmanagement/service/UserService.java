package com.example.taskmanagement.service;

import com.example.taskmanagement.dto.request.UserRequestDto;
import com.example.taskmanagement.dto.response.UserResponseDto;

import java.util.List;

public interface UserService {
    UserResponseDto create(UserRequestDto requestDto);

    List<UserResponseDto> getAll();

    UserResponseDto getById(Long id);

    void delete(Long id);
}
