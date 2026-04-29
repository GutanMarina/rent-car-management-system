package com.example.carrentalmanagementtmppp.patterns.behavioral.chain;

import java.time.temporal.ChronoUnit;

public class ReservationDatesValidationHandler extends ReservationValidationHandler {

    @Override
    protected void validate(ReservationValidationContext context) {
        long days = ChronoUnit.DAYS.between(context.getStartDate(), context.getEndDate());

        if (days <= 0) {
            throw new RuntimeException("End date must be after start date");
        }
    }
}
