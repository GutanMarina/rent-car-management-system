package com.example.carrentalmanagementtmppp.service;

import com.example.carrentalmanagementtmppp.model.Payment;

import java.util.List;
import java.util.Optional;

public interface PaymentService {
    Payment createPayment(Long reservationId, String paymentMethod);
    List<Payment> getAllPayments();
    Optional<Payment> getPaymentById(Long id);
}