package com.example.carrentalmanagementtmppp.patterns.behavioral.chain;

public abstract class ReservationValidationHandler {

    private ReservationValidationHandler next;

    public ReservationValidationHandler setNext(ReservationValidationHandler next) {
        this.next = next;
        return next;
    }

    public void handle(ReservationValidationContext context) {
        validate(context);
        if (next != null) {
            next.handle(context);
        }
    }

    protected abstract void validate(ReservationValidationContext context);
}
