package com.example.carrentalmanagementtmppp.patterns.behavioral.state;

public class CompletedState implements ReservationState {

    private ReservationContext reservation;

    @Override
    public void confirm() {
        throw new IllegalStateException("Completed reservation cannot be confirmed again");
    }

    @Override
    public void cancel() {
        throw new IllegalStateException("Completed reservation cannot be cancelled");
    }

    @Override
    public void complete() {
        throw new IllegalStateException("Reservation is already completed");
    }

    @Override
    public String getStateName() {
        return "COMPLETED";
    }

    @Override
    public void setReservation(ReservationContext reservation) {
        this.reservation = reservation;
    }
}