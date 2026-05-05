package com.example.carrentalmanagementtmppp.mapper;

import com.example.carrentalmanagementtmppp.dto.response.PaymentResponse;
import com.example.carrentalmanagementtmppp.model.Payment;

public class PaymentMapper {

    private PaymentMapper() {
    }

    public static PaymentResponse toResponse(Payment payment) {
        return new PaymentResponse(
                payment.getId(),
                payment.getReservation().getId(),
                payment.getAmount(),
                payment.getPaymentMethod(),
                payment.getStatus().name()
        );
    }
}