package com.example.carrentalmanagementtmppp.patterns.behavioral.state;
import com.example.carrentalmanagementtmppp.enums.ReservationStatus;
import com.example.carrentalmanagementtmppp.model.Car;

public interface ReservationContext {
    void setState(ReservationState state);
    void setStatus(ReservationStatus status);
    ReservationStatus getStatus();
    Car getCar();
}
