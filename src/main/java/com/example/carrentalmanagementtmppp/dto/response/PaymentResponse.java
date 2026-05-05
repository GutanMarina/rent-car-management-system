package com.example.carrentalmanagementtmppp.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PaymentResponse {

    private Long id;
    private Long reservationId;
    private Double amount;
    private String paymentMethod;
    private String status;
}
