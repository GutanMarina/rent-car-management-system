package com.example.carrentalmanagementtmppp.service;

import com.example.carrentalmanagementtmppp.model.Car;
import com.example.carrentalmanagementtmppp.enums.CarType;

import java.util.List;
import java.util.Optional;

public interface CarService {
    Car saveCar(Car car);
    List<Car> getAllCars();
    Optional<Car> getCarById(Long id);
    List<Car> getAvailableCars();
    List<Car> getCarsByType(CarType carType);
    List<Car> searchCars(String keyword);}
