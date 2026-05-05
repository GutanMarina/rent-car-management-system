package com.example.carrentalmanagementtmppp.dto.request;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CreateReservationRequest {

    @NotNull(message = "Car id is required")
    private Long carId;

    @NotNull(message = "User id is required")
    private Long userId;

    @NotNull(message = "Start date is required")
    @FutureOrPresent(message = "Start date must be today or in the future")
    private LocalDate startDate;

    @NotNull(message = "End date is required")
    private LocalDate endDate;

    private boolean gps;

    private boolean childSeat;

    private boolean insurance;

    private String packageType = "STANDARD";
}