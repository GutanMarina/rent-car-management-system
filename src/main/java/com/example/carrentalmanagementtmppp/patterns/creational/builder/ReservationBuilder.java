package com.example.carrentalmanagementtmppp.patterns.creational.builder;

import com.example.carrentalmanagementtmppp.enums.ReservationStatus;
import com.example.carrentalmanagementtmppp.model.Car;
import com.example.carrentalmanagementtmppp.model.Reservation;
import com.example.carrentalmanagementtmppp.model.User;

import java.time.LocalDate;

public interface ReservationBuilder {
    ReservationBuilder setCar(Car car);
    ReservationBuilder setUser(User user);
    ReservationBuilder setStartDate(LocalDate startDate);
    ReservationBuilder setEndDate(LocalDate endDate);
    ReservationBuilder setTotalPrice(Double totalPrice);
    ReservationBuilder setStatus(ReservationStatus status);
    ReservationBuilder setGps(boolean gps);
    ReservationBuilder setChildSeat(boolean childSeat);
    ReservationBuilder setInsurance(boolean insurance);
    ReservationBuilder setOptionsDescription(String optionsDescription);
    ReservationBuilder setPackageType(String packageType);
    ReservationBuilder setAssistanceLevel(String assistanceLevel);
    Reservation build();
}
