package com.example.carrentalmanagementtmppp.service.impl;

import com.example.carrentalmanagementtmppp.dto.request.LoginRequest;
import com.example.carrentalmanagementtmppp.dto.request.RegisterRequest;
import com.example.carrentalmanagementtmppp.enums.UserRole;
import com.example.carrentalmanagementtmppp.model.User;
import com.example.carrentalmanagementtmppp.repository.UserRepository;
import com.example.carrentalmanagementtmppp.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    public AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User register(RegisterRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email is already used");
        }

        User user = User.builder()
                .fullName(request.getFullName())
                .email(request.getEmail())
                .phone(request.getPhone())
                .password(request.getPassword())
                .role(UserRole.USER)
                .build();

        return userRepository.save(user);
    }

    @Override
    public User login(LoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid email or password"));

        if (!user.getPassword().equals(request.getPassword())) {
            throw new RuntimeException("Invalid email or password");
        }

        return user;
    }
}