package com.example.carrentalmanagementtmppp.controller;

import com.example.carrentalmanagementtmppp.patterns.creational.prototype.RentalContract;
import com.example.carrentalmanagementtmppp.service.RentalContractService;
import org.springframework.web.bind.annotation.*;

import com.example.carrentalmanagementtmppp.patterns.creational.prototype.RentalContract;
import com.example.carrentalmanagementtmppp.patterns.structural.facade.RentalFacade;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contracts")
public class RentalContractController {

    private final RentalFacade rentalFacade;

    public RentalContractController(RentalFacade rentalFacade) {
        this.rentalFacade = rentalFacade;
    }

    @GetMapping("/generate/{reservationId}")
    public RentalContract generateContract(@PathVariable Long reservationId) {
        return rentalFacade.generateContract(reservationId);
    }
}