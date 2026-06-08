package com.malkris.stockmanagement.user.controller;

import com.malkris.stockmanagement.common.response.ApiResponse;
import com.malkris.stockmanagement.user.dto.AuthResponse;
import com.malkris.stockmanagement.user.dto.LoginRequest;
import com.malkris.stockmanagement.user.dto.RegisterRequest;
import com.malkris.stockmanagement.user.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ApiResponse<AuthResponse> register(
            @Valid @RequestBody RegisterRequest request
    ) {

        return ApiResponse.success(
                "User registered successfully",
                authService.register(request)
        );
    }

    @PostMapping("/login")
    public ApiResponse<AuthResponse> login(
            @Valid @RequestBody LoginRequest request
    ) {

        return ApiResponse.success(
                "Login successful",
                authService.login(request)
        );
    }
}