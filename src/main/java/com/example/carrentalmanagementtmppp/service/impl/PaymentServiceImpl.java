package com.example.carrentalmanagementtmppp.service.impl;

import com.example.carrentalmanagementtmppp.enums.PaymentStatus;
import com.example.carrentalmanagementtmppp.model.Payment;
import com.example.carrentalmanagementtmppp.model.Reservation;
import com.example.carrentalmanagementtmppp.patterns.structural.adapter.*;
import com.example.carrentalmanagementtmppp.repository.PaymentRepository;
import com.example.carrentalmanagementtmppp.repository.ReservationRepository;
import com.example.carrentalmanagementtmppp.service.PaymentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final ReservationRepository reservationRepository;

    public PaymentServiceImpl(PaymentRepository paymentRepository,
                              ReservationRepository reservationRepository) {
        this.paymentRepository = paymentRepository;
        this.reservationRepository = reservationRepository;
    }

    @Override
    public Payment createPayment(Long reservationId, String paymentMethod) {
        Reservation reservation = reservationRepository.findById(reservationId)
                .orElseThrow(() -> new RuntimeException("Reservation not found"));

        PaymentProcessor paymentProcessor;

        if ("STRIPE".equalsIgnoreCase(paymentMethod)) {
            paymentProcessor = new StripeAdapter(new StripeGateway());
        } else if ("PAYPAL".equalsIgnoreCase(paymentMethod)) {
            paymentProcessor = new PayPalAdapter(new PayPalGateway());
        } else {
            throw new RuntimeException("Unsupported payment method");
        }

        boolean paymentSuccess = paymentProcessor.processPayment(reservation.getTotalPrice());

        Payment payment = Payment.builder()
                .reservation(reservation)
                .amount(reservation.getTotalPrice())
                .paymentMethod(paymentMethod.toUpperCase())
                .status(paymentSuccess ? PaymentStatus.PAID : PaymentStatus.FAILED)
                .build();

        return paymentRepository.save(payment);
    }

    @Override
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    @Override
    public Optional<Payment> getPaymentById(Long id) {
        return paymentRepository.findById(id);
    }
}