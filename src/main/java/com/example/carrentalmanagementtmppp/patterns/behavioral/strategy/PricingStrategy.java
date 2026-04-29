package com.example.carrentalmanagementtmppp.patterns.behavioral.strategy;
import com.example.carrentalmanagementtmppp.model.Car;

import java.time.LocalDate;

public interface PricingStrategy {
    double calculatePrice(Car car, LocalDate startDate, LocalDate endDate);
}