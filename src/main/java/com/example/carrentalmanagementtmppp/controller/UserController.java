package com.example.carrentalmanagementtmppp.controller;
import com.example.carrentalmanagementtmppp.dto.request.CreateUserRequest;
import com.example.carrentalmanagementtmppp.dto.response.UserResponse;
import com.example.carrentalmanagementtmppp.enums.UserRole;
import com.example.carrentalmanagementtmppp.mapper.UserMapper;
import com.example.carrentalmanagementtmppp.model.User;
import com.example.carrentalmanagementtmppp.patterns.structural.facade.RentalFacade;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final RentalFacade rentalFacade;

    public UserController(RentalFacade rentalFacade) {
        this.rentalFacade = rentalFacade;
    }

    @PostMapping
    public UserResponse addUser(@Valid @RequestBody CreateUserRequest request) {
        User user = User.builder()
                .fullName(request.getFullName())
                .email(request.getEmail())
                .phone(request.getPhone())
                .password(request.getPassword())
                .role(UserRole.USER)
                .build();

        User savedUser = rentalFacade.addUser(user);
        return UserMapper.toResponse(savedUser);
    }

    @GetMapping
    public List<UserResponse> getAllUsers() {
        return rentalFacade.getAllUsers()
                .stream()
                .map(UserMapper::toResponse)
                .toList();
    }

    @GetMapping("/{id}")
    public UserResponse getUserById(@PathVariable Long id) {
        User user = rentalFacade.getUserById(id);
        return UserMapper.toResponse(user);
    }
}