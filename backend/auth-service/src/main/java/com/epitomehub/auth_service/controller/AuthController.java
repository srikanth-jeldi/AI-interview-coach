package com.epitomehub.auth_service.controller;

import com.epitomehub.auth_service.dto.AuthDtos.*;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @PostMapping("/register")
    public TokenResponse register(@Valid @RequestBody RegisterRequest request) {
        return new TokenResponse("access-token-placeholder", "refresh-token-placeholder", 900);
    }
    @PostMapping("/login")
    public TokenResponse login(@Valid @RequestBody LoginRequest request) {
        return new TokenResponse("access-token-placeholder", "refresh-token-placeholder", 900);
    }
    @PostMapping("/refresh")
    public TokenResponse refresh() {
        return new TokenResponse("rotated-access-token-placeholder", "rotated-refresh-token-placeholder", 900);
    }
}
