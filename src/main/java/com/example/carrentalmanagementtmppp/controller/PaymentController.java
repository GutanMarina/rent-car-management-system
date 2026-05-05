package com.example.carrentalmanagementtmppp.controller;

import com.example.carrentalmanagementtmppp.dto.request.CreatePaymentRequest;
import com.example.carrentalmanagementtmppp.dto.response.PaymentResponse;
import com.example.carrentalmanagementtmppp.mapper.PaymentMapper;
import jakarta.validation.Valid;
import com.example.carrentalmanagementtmppp.model.Payment;
import com.example.carrentalmanagementtmppp.patterns.structural.facade.RentalFacade;
import com.example.carrentalmanagementtmppp.service.PaymentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    private final RentalFacade rentalFacade;

    public PaymentController(RentalFacade rentalFacade) {
        this.rentalFacade = rentalFacade;
    }

    @PostMapping
    public PaymentResponse createPayment(@Valid @RequestBody CreatePaymentRequest request) {

        return PaymentMapper.toResponse(
                rentalFacade.createPayment(
                        request.getReservationId(),
                        request.getPaymentMethod()
                )
        );
    }

    @GetMapping
    public List<Payment> getAllPayments() {
        return rentalFacade.getAllPayments();
    }

    @GetMapping("/{id}")
    public Payment getPaymentById(@PathVariable Long id) {
        return rentalFacade.getPaymentById(id);
    }
}