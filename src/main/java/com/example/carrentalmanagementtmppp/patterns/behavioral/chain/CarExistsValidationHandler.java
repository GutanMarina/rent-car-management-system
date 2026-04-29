package com.example.carrentalmanagementtmppp.patterns.behavioral.chain;

import com.example.carrentalmanagementtmppp.repository.CarRepository;

public class CarExistsValidationHandler extends ReservationValidationHandler {

    private final CarRepository carRepository;

    public CarExistsValidationHandler(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    protected void validate(ReservationValidationContext context) {
        if (carRepository.findById(context.getCarId()).isEmpty()) {
            throw new RuntimeException("Car not found");
        }
    }
}
