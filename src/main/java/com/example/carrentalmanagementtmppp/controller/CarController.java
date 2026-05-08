package com.example.carrentalmanagementtmppp.controller;
import com.example.carrentalmanagementtmppp.dto.request.CreateCarRequest;
import com.example.carrentalmanagementtmppp.dto.request.UpdateCarStatusRequest;
import com.example.carrentalmanagementtmppp.dto.response.CarResponse;
import com.example.carrentalmanagementtmppp.mapper.CarMapper;
import com.example.carrentalmanagementtmppp.model.Car;
import com.example.carrentalmanagementtmppp.patterns.structural.facade.RentalFacade;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import com.example.carrentalmanagementtmppp.enums.CarType;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {

    private final RentalFacade rentalFacade;

    public CarController(RentalFacade rentalFacade) {
        this.rentalFacade = rentalFacade;
    }

    @PostMapping
    public CarResponse addCar(@Valid @RequestBody CreateCarRequest request) {
        Car car = Car.builder()
                .brand(request.getBrand())
                .model(request.getModel())
                .licensePlate(request.getLicensePlate())
                .pricePerDay(request.getPricePerDay())
                .status(request.getStatus())
                .carType(request.getCarType())
                .seats(request.getSeats())
                .fuelType(request.getFuelType())
                .transmissionType(request.getTransmissionType())
                .imageUrl(request.getImageUrl())
                .build();

        Car savedCar = rentalFacade.addCar(car);
        return CarMapper.toResponse(savedCar);
    }

    @GetMapping
    public List<CarResponse> getAllCars() {
        return rentalFacade.getAllCars()
                .stream()
                .map(CarMapper::toResponse)
                .toList();
    }

    @GetMapping("/{id}")
    public CarResponse getCarById(@PathVariable Long id) {
        Car car = rentalFacade.getCarById(id);
        return CarMapper.toResponse(car);
    }
    @GetMapping("/available")
    public List<CarResponse> getAvailableCars() {
        return rentalFacade.getAvailableCars()
                .stream()
                .map(CarMapper::toResponse)
                .toList();
    }
    @GetMapping("/type/{carType}")
    public List<CarResponse> getCarsByType(@PathVariable CarType carType) {
        return rentalFacade.getCarsByType(carType)
                .stream()
                .map(CarMapper::toResponse)
                .toList();
    }

    @GetMapping("/search")
    public List<CarResponse> searchCars(@RequestParam String keyword) {
        return rentalFacade.searchCars(keyword)
                .stream()
                .map(CarMapper::toResponse)
                .toList();
    }
    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable Long id) {
        rentalFacade.deleteCar(id);
    }

    @PutMapping("/{id}/status")
    public CarResponse updateCarStatus(@PathVariable Long id,
                                       @Valid @RequestBody UpdateCarStatusRequest request) {
        Car updatedCar = rentalFacade.updateCarStatus(id, request.getStatus());
        return CarMapper.toResponse(updatedCar);
    }
}