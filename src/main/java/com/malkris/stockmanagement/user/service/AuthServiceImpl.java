package com.malkris.stockmanagement.user.service;

import com.malkris.stockmanagement.exception.BadRequestException;
import com.malkris.stockmanagement.security.JwtService;
import com.malkris.stockmanagement.user.dto.AuthResponse;
import com.malkris.stockmanagement.user.dto.LoginRequest;
import com.malkris.stockmanagement.user.dto.RegisterRequest;
import com.malkris.stockmanagement.user.entity.Role;
import com.malkris.stockmanagement.user.entity.User;
import com.malkris.stockmanagement.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl
        implements AuthService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    @Override
    public AuthResponse register(RegisterRequest request) {

        if (userRepository.existsByEmail(request.getEmail())) {

            throw new BadRequestException(
                    "Email already exists"
            );
        }

        User user = User.builder()

                .name(request.getName())

                .email(request.getEmail())

                .password(
                        passwordEncoder.encode(
                                request.getPassword()
                        )
                )

                .role(Role.ADMIN)

                .build();

        userRepository.save(user);

        String token =
                jwtService.generateToken(
                        org.springframework.security.core.userdetails
                                .User
                                .builder()
                                .username(user.getName())
                                .password(user.getPassword())
                                .roles(user.getRole().name())
                                .build()
                );

        return AuthResponse.builder()

                .token(token)

                .email(user.getEmail())

                .role(user.getRole().name())

                .build();
    }

    @Override
    public AuthResponse login(LoginRequest request) {
        System.out.println("Login  attempt for user: " + request.getName());

        authenticationManager.authenticate(

                new UsernamePasswordAuthenticationToken(
                        request.getName(),
                        request.getPassword()
                )
        );

        User user =
                userRepository.findByName(request.getName())
                        .orElseThrow(() ->
                                new BadRequestException(
                                        "Invalid credentials"
                                )
                        );

        String token =
                jwtService.generateToken(
                        org.springframework.security.core.userdetails
                                .User
                                .builder()
                                .username(user.getName())
                                .password(user.getPassword())
                                .roles(user.getRole().name())
                                .build()
                );

        return AuthResponse.builder()

                .token(token)

                .email(user.getEmail())

                .role(user.getRole().name())

                .name(user.getName())

                .build();
    }
}