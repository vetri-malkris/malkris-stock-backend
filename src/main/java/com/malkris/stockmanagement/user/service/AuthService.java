package com.malkris.stockmanagement.user.service;

import com.malkris.stockmanagement.user.dto.AuthResponse;
import com.malkris.stockmanagement.user.dto.LoginRequest;
import com.malkris.stockmanagement.user.dto.RegisterRequest;

public interface AuthService {

    AuthResponse register(RegisterRequest request);

    AuthResponse login(LoginRequest request);
}