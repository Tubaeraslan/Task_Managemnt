package com.example.taskmanagement.dto.response;

public record AuthResponse(
        String token,
        String type,
        String email
) {
    public AuthResponse(String token, String email) {
        this(token, "Bearer", email);
    }
}
