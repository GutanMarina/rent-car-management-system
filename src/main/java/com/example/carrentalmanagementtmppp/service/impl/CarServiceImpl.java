package com.example.carrentalmanagementtmppp.service.impl;
import com.example.carrentalmanagementtmppp.model.Car;
import com.example.carrentalmanagementtmppp.repository.CarRepository;
import com.example.carrentalmanagementtmppp.service.CarService;
import org.springframework.stereotype.Service;
import com.example.carrentalmanagementtmppp.enums.*;

import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public Car saveCar(Car car) {
        return carRepository.save(car);
    }

    @Override
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @Override
    public Optional<Car> getCarById(Long id) {
        return carRepository.findById(id);
    }
    @Override
    public List<Car> getAvailableCars() {
        return carRepository.findByStatus(CarStatus.AVAILABLE);
    }
    @Override
    public List<Car> getCarsByType(CarType carType) {
        return carRepository.findByCarType(carType);
    }
    @Override
    public List<Car> searchCars(String keyword) {
        return carRepository.searchCars(keyword.trim());
    }
    @Override
    public void deleteCar(Long id) {
        if (!carRepository.existsById(id)) {
            throw new RuntimeException("Car not found");
        }

        carRepository.deleteById(id);
    }

    @Override
    public Car updateCarStatus(Long id, CarStatus status) {
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Car not found"));

        car.setStatus(status);
        return carRepository.save(car);
    }
}