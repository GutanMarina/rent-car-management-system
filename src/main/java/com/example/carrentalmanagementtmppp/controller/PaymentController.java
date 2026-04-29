package com.example.carrentalmanagementtmppp.controller;


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
    public Payment createPayment(@RequestParam Long reservationId,
                                 @RequestParam String paymentMethod) {
        return rentalFacade.createPayment(reservationId, paymentMethod);
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