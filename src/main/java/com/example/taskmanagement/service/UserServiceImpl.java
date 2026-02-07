package com.example.taskmanagement.service;

import com.example.taskmanagement.dto.request.UserRequestDto;
import com.example.taskmanagement.dto.response.UserResponseDto;
import com.example.taskmanagement.entity.User;
import com.example.taskmanagement.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserResponseDto create(UserRequestDto requestDto) {

        if (userRepository.existsByEmail(requestDto.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        User user = new User();
        user.setEmail(requestDto.getEmail());
        user.setPassword(requestDto.getPassword()); // 4. hafta encode edilecek

        User saved = userRepository.save(user);

        UserResponseDto response = new UserResponseDto();
        response.setId(saved.getId());
        response.setEmail(saved.getEmail());

        return response;
    }

    @Override
    public List<UserResponseDto> getAll() {
        return userRepository.findAll()
                .stream()
                .map(user -> {
                    UserResponseDto dto = new UserResponseDto();
                    dto.setId(user.getId());
                    dto.setEmail(user.getEmail());
                    return dto;
                })
                .toList();
    }

    @Override
    public UserResponseDto getById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        UserResponseDto dto = new UserResponseDto();
        dto.setId(user.getId());
        dto.setEmail(user.getEmail());

        return dto;
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
