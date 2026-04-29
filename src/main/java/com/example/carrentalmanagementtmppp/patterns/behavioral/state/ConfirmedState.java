package com.example.carrentalmanagementtmppp.patterns.behavioral.state;

import com.example.carrentalmanagementtmppp.enums.CarStatus;
import com.example.carrentalmanagementtmppp.enums.ReservationStatus;

public class ConfirmedState implements ReservationState {

    private ReservationContext reservation;

    @Override
    public void confirm() {
        throw new IllegalStateException("Reservation is already confirmed");
    }

    @Override
    public void cancel() {
        reservation.setStatus(ReservationStatus.CANCELLED);
        reservation.getCar().setStatus(CarStatus.AVAILABLE);
        reservation.setState(new CancelledState());
    }

    @Override
    public void complete() {
        reservation.setStatus(ReservationStatus.COMPLETED);
        reservation.getCar().setStatus(CarStatus.AVAILABLE);
        reservation.setState(new CompletedState());
    }

    @Override
    public String getStateName() {
        return "CONFIRMED";
    }

    @Override
    public void setReservation(ReservationContext reservation) {
        this.reservation = reservation;
    }
}