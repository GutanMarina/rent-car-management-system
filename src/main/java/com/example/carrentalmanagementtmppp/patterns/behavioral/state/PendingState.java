package com.example.carrentalmanagementtmppp.patterns.behavioral.state;

import com.example.carrentalmanagementtmppp.enums.CarStatus;
import com.example.carrentalmanagementtmppp.enums.ReservationStatus;

public class PendingState implements ReservationState {

    private ReservationContext reservation;

    @Override
    public void confirm() {
        reservation.setStatus(ReservationStatus.CONFIRMED);
        reservation.setState(new ConfirmedState());
    }

    @Override
    public void cancel() {
        reservation.setStatus(ReservationStatus.CANCELLED);
        reservation.getCar().setStatus(CarStatus.AVAILABLE);
        reservation.setState(new CancelledState());
    }

    @Override
    public void complete() {
        throw new IllegalStateException("Pending reservation cannot be completed directly");
    }

    @Override
    public String getStateName() {
        return "PENDING";
    }

    @Override
    public void setReservation(ReservationContext reservation) {
        this.reservation = reservation;
    }
}