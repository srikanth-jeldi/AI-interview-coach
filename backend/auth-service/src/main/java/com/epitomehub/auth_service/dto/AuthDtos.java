package com.epitomehub.auth_service.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class AuthDtos {
    public record RegisterRequest(@Email String email, @NotBlank String password, @NotBlank String fullName, int yearsOfExperience) {}
    public record LoginRequest(@Email String email, @NotBlank String password) {}
    public record TokenResponse(String accessToken, String refreshToken, long expiresInSeconds) {}
}
