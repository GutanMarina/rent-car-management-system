package com.example.carrentalmanagementtmppp.patterns.behavioral.state;

public class CancelledState implements ReservationState {

    private ReservationContext reservation;

    @Override
    public void confirm() {
        throw new IllegalStateException("Cancelled reservation cannot be confirmed");
    }

    @Override
    public void cancel() {
        throw new IllegalStateException("Reservation is already cancelled");
    }

    @Override
    public void complete() {
        throw new IllegalStateException("Cancelled reservation cannot be completed");
    }

    @Override
    public String getStateName() {
        return "CANCELLED";
    }

    @Override
    public void setReservation(ReservationContext reservation) {
        this.reservation = reservation;
    }
}