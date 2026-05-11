package com.example.carrentalmanagementtmppp.controller;

import com.example.carrentalmanagementtmppp.dto.request.LoginRequest;
import com.example.carrentalmanagementtmppp.dto.request.RegisterRequest;
import com.example.carrentalmanagementtmppp.dto.response.UserResponse;
import com.example.carrentalmanagementtmppp.mapper.UserMapper;
import com.example.carrentalmanagementtmppp.model.User;
import com.example.carrentalmanagementtmppp.service.AuthService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public UserResponse register(@Valid @RequestBody RegisterRequest request, HttpSession session) {
        User user = authService.register(request);
        session.setAttribute("loggedUser", user);
        return UserMapper.toResponse(user);
    }

    @PostMapping("/login")
    public UserResponse login(@Valid @RequestBody LoginRequest request, HttpSession session) {
        User user = authService.login(request);
        session.setAttribute("loggedUser", user);
        return UserMapper.toResponse(user);
    }

    @PostMapping("/logout")
    public void logout(HttpSession session) {
        session.invalidate();
    }

    @GetMapping("/me")
    public UserResponse currentUser(HttpSession session) {
        User user = (User) session.getAttribute("loggedUser");

        if (user == null) {
            throw new RuntimeException("User is not logged in");
        }

        return UserMapper.toResponse(user);
    }
}
