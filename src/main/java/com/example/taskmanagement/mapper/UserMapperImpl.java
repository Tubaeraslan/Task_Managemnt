package com.example.taskmanagement.mapper;

import com.example.taskmanagement.dto.request.UserRequestDto;
import com.example.taskmanagement.dto.response.UserResponseDto;
import com.example.taskmanagement.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImpl implements UserMapper{
    @Override
    public User toEntity(UserRequestDto dto) {
        User user = new User();
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        return user;
    }

    @Override
    public UserResponseDto toDto(User user) {
        UserResponseDto dto = new UserResponseDto();
        dto.setId(user.getId());
        dto.setEmail(user.getEmail());
        return dto;
    }
}
