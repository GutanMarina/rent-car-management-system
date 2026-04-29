package com.example.carrentalmanagementtmppp.patterns.behavioral.chain;

import java.time.LocalDate;

public class ReservationValidationContext {

    private final Long carId;
    private final Long userId;
    private final LocalDate startDate;
    private final LocalDate endDate;

    public ReservationValidationContext(Long carId, Long userId, LocalDate startDate, LocalDate endDate) {
        this.carId = carId;
        this.userId = userId;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Long getCarId() {
        return carId;
    }

    public Long getUserId() {
        return userId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }
}
