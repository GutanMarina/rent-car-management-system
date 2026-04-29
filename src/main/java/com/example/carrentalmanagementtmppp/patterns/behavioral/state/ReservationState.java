package com.example.carrentalmanagementtmppp.patterns.behavioral.state;

public interface ReservationState {
    void confirm();
    void cancel();
    void complete();
    String getStateName();
    void setReservation(ReservationContext reservation);
}