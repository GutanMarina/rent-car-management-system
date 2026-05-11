package com.example.carrentalmanagementtmppp.service;

import com.example.carrentalmanagementtmppp.dto.request.LoginRequest;
import com.example.carrentalmanagementtmppp.dto.request.RegisterRequest;
import com.example.carrentalmanagementtmppp.model.User;

public interface AuthService {
    User register(RegisterRequest request);
    User login(LoginRequest request);
}
