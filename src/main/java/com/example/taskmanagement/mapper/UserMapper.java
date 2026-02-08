package com.example.taskmanagement.mapper;

import com.example.taskmanagement.dto.request.UserRequestDto;
import com.example.taskmanagement.dto.response.UserResponseDto;
import com.example.taskmanagement.entity.User;

public interface UserMapper {
    User toEntity(UserRequestDto dto);

    UserResponseDto toDto(User user);
}
