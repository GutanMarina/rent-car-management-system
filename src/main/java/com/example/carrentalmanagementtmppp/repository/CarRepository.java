package com.example.carrentalmanagementtmppp.repository;

import com.example.carrentalmanagementtmppp.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}