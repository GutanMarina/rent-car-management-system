package com.example.carrentalmanagementtmppp.patterns.creational.builder;

import com.example.carrentalmanagementtmppp.enums.ReservationStatus;
import com.example.carrentalmanagementtmppp.model.Car;
import com.example.carrentalmanagementtmppp.model.Reservation;
import com.example.carrentalmanagementtmppp.model.User;

import java.time.LocalDate;

public class DefaultReservationBuilder implements ReservationBuilder {

    private Car car;
    private User user;
    private LocalDate startDate;
    private LocalDate endDate;
    private Double totalPrice;
    private ReservationStatus status;
    private boolean gps;
    private boolean childSeat;
    private boolean insurance;
    private String optionsDescription;
    private String packageType;
    private String assistanceLevel;
    private String pickupLocation;

    @Override
    public ReservationBuilder setCar(Car car) {
        this.car = car;
        return this;
    }

    @Override
    public ReservationBuilder setUser(User user) {
        this.user = user;
        return this;
    }

    @Override
    public ReservationBuilder setStartDate(LocalDate startDate) {
        this.startDate = startDate;
        return this;
    }

    @Override
    public ReservationBuilder setEndDate(LocalDate endDate) {
        this.endDate = endDate;
        return this;
    }

    @Override
    public ReservationBuilder setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
        return this;
    }

    @Override
    public ReservationBuilder setStatus(ReservationStatus status) {
        this.status = status;
        return this;
    }

    @Override
    public ReservationBuilder setGps(boolean gps) {
        this.gps = gps;
        return this;
    }

    @Override
    public ReservationBuilder setChildSeat(boolean childSeat) {
        this.childSeat = childSeat;
        return this;
    }

    @Override
    public ReservationBuilder setInsurance(boolean insurance) {
        this.insurance = insurance;
        return this;
    }

    @Override
    public ReservationBuilder setOptionsDescription(String optionsDescription) {
        this.optionsDescription = optionsDescription;
        return this;
    }
    @Override
    public ReservationBuilder setPackageType(String packageType) {
        this.packageType = packageType;
        return this;
    }

    @Override
    public ReservationBuilder setAssistanceLevel(String assistanceLevel) {
        this.assistanceLevel = assistanceLevel;
        return this;
    }
    @Override
    public ReservationBuilder setPickupLocation(String pickupLocation) {
        this.pickupLocation = pickupLocation;
        return this;
    }

    @Override
    public Reservation build() {
        if (car == null) {
            throw new IllegalStateException("Car must not be null");
        }
        if (user == null) {
            throw new IllegalStateException("User must not be null");
        }
        if (startDate == null || endDate == null) {
            throw new IllegalStateException("Dates must not be null");
        }
        if (totalPrice == null) {
            throw new IllegalStateException("Total price must not be null");
        }
        if (status == null) {
            throw new IllegalStateException("Status must not be null");
        }
        if (pickupLocation == null || pickupLocation.isBlank()) {
            throw new IllegalStateException("Pickup location must not be empty");
        }

        return Reservation.builder()
                .car(car)
                .user(user)
                .startDate(startDate)
                .endDate(endDate)
                .totalPrice(totalPrice)
                .status(status)
                .gps(gps)
                .childSeat(childSeat)
                .insurance(insurance)
                .optionsDescription(optionsDescription)
                .packageType(packageType)
                .assistanceLevel(assistanceLevel)
                .pickupLocation(pickupLocation)
                .build();
    }
}
