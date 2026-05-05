package com.example.carrentalmanagementtmppp.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreatePaymentRequest {

    @NotNull(message = "Reservation id is required")
    private Long reservationId;

    @NotNull(message = "Payment method is required")
    private String paymentMethod;
}
