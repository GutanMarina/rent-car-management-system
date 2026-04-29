package com.example.carrentalmanagementtmppp.patterns.behavioral.chain;

import com.example.carrentalmanagementtmppp.repository.UserRepository;

public class UserExistsValidationHandler extends ReservationValidationHandler {

    private final UserRepository userRepository;

    public UserExistsValidationHandler(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    protected void validate(ReservationValidationContext context) {
        if (userRepository.findById(context.getUserId()).isEmpty()) {
            throw new RuntimeException("User not found");
        }
    }
}
