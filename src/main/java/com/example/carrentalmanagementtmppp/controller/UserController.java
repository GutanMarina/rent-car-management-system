package com.example.carrentalmanagementtmppp.controller;
import com.example.carrentalmanagementtmppp.model.User;
import com.example.carrentalmanagementtmppp.patterns.structural.facade.RentalFacade;
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
    public User addUser(@RequestBody User user) {
        return rentalFacade.addUser(user);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return rentalFacade.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return rentalFacade.getUserById(id);
    }
}