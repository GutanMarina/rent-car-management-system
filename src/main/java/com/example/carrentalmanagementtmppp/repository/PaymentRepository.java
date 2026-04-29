package com.example.carrentalmanagementtmppp.repository;

import com.example.carrentalmanagementtmppp.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}