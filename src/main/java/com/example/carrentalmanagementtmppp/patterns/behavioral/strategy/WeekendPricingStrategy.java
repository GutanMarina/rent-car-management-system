package com.example.carrentalmanagementtmppp.patterns.behavioral.strategy;

import com.example.carrentalmanagementtmppp.model.Car;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class WeekendPricingStrategy implements PricingStrategy {

    @Override
    public double calculatePrice(Car car, LocalDate startDate, LocalDate endDate) {
        long days = ChronoUnit.DAYS.between(startDate, endDate);
        double total = car.getPricePerDay() * days;

        if (startDate.getDayOfWeek() == DayOfWeek.SATURDAY ||
                startDate.getDayOfWeek() == DayOfWeek.SUNDAY) {
            total = total * 1.20;
        }

        return total;
    }
}