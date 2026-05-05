package com.example.carrentalmanagementtmppp.mapper;

import com.example.carrentalmanagementtmppp.dto.response.UserResponse;
import com.example.carrentalmanagementtmppp.model.User;

public class UserMapper {

    private UserMapper() {
    }

    public static UserResponse toResponse(User user) {
        return new UserResponse(
                user.getId(),
                user.getFullName(),
                user.getEmail(),
                user.getPhone()
        );
    }
}
