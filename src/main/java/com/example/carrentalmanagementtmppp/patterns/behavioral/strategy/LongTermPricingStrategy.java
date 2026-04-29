package com.example.carrentalmanagementtmppp.patterns.behavioral.strategy;
import com.example.carrentalmanagementtmppp.model.Car;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class LongTermPricingStrategy implements PricingStrategy {

    @Override
    public double calculatePrice(Car car, LocalDate startDate, LocalDate endDate) {
        long days = ChronoUnit.DAYS.between(startDate, endDate);
        double total = car.getPricePerDay() * days;
        return total * 0.85;
    }
}