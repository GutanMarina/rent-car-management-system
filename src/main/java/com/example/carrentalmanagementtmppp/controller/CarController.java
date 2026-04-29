package com.example.carrentalmanagementtmppp.controller;

import com.example.carrentalmanagementtmppp.model.Car;
import org.springframework.web.bind.annotation.*;

import com.example.carrentalmanagementtmppp.patterns.structural.facade.RentalFacade;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {

    private final RentalFacade rentalFacade;

    public CarController(RentalFacade rentalFacade) {
        this.rentalFacade = rentalFacade;
    }

    @PostMapping
    public Car addCar(@RequestBody Car car) {
        return rentalFacade.addCar(car);
    }

    @GetMapping
    public List<Car> getAllCars() {
        return rentalFacade.getAllCars();
    }

    @GetMapping("/{id}")
    public Car getCarById(@PathVariable Long id) {
        return rentalFacade.getCarById(id);
    }
}