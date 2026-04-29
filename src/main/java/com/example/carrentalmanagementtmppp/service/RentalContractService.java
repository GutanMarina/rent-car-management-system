package com.example.carrentalmanagementtmppp.service;

import com.example.carrentalmanagementtmppp.patterns.creational.prototype.RentalContract;

public interface RentalContractService {
    RentalContract generateContract(Long reservationId);
}