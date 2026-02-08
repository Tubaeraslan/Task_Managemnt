package com.example.taskmanagement.dto.request;

public record AuthRequest(
        String email,
        String password
) {
}
