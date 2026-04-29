package com.example.carrentalmanagementtmppp.patterns.behavioral.chain;

import com.example.carrentalmanagementtmppp.enums.CarStatus;
import com.example.carrentalmanagementtmppp.model.Car;
import com.example.carrentalmanagementtmppp.repository.CarRepository;

public class CarAvailabilityValidationHandler extends ReservationValidationHandler {

    private final CarRepository carRepository;

    public CarAvailabilityValidationHandler(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    protected void validate(ReservationValidationContext context) {
        Car car = carRepository.findById(context.getCarId())
                .orElseThrow(() -> new RuntimeException("Car not found"));

        if (car.getStatus() != CarStatus.AVAILABLE) {
            throw new RuntimeException("Car is not available for reservation");
        }
    }
}
