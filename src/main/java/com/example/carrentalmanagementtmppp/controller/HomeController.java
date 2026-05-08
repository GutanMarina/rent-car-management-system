package com.example.carrentalmanagementtmppp.controller;

import org.springframework.ui.Model;
import com.example.carrentalmanagementtmppp.mapper.CarMapper;
import com.example.carrentalmanagementtmppp.patterns.structural.facade.RentalFacade;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.carrentalmanagementtmppp.mapper.ReservationMapper;
import com.example.carrentalmanagementtmppp.patterns.creational.prototype.RentalContract;

@Controller
public class HomeController {

    private final RentalFacade rentalFacade;

    public HomeController(RentalFacade rentalFacade) {
        this.rentalFacade = rentalFacade;
    }

    @GetMapping("/")
    public String home(Model model) {

        model.addAttribute(
                "cars",
                rentalFacade.getAvailableCars()
                        .stream()
                        .map(CarMapper::toResponse)
                        .toList()
        );

        return "index";
    }
    @GetMapping("/cars-page/{id}")
    public String carDetails(@PathVariable Long id, Model model) {
        model.addAttribute(
                "car",
                CarMapper.toResponse(rentalFacade.getCarById(id))
        );

        return "car-details";
    }
    @GetMapping("/reservation-page/{id}")
    public String reservationDetails(@PathVariable Long id, Model model) {
        model.addAttribute(
                "reservation",
                ReservationMapper.toResponse(rentalFacade.getReservationById(id))
        );

        return "reservation-details";
    }
    @GetMapping("/payment-page/{reservationId}")
    public String paymentPage(@PathVariable Long reservationId, Model model) {
        model.addAttribute(
                "reservation",
                ReservationMapper.toResponse(rentalFacade.getReservationById(reservationId))
        );

        return "payment";
    }
    @GetMapping("/contract-page/{reservationId}")
    public String contractPage(@PathVariable Long reservationId, Model model) {
        RentalContract contract = rentalFacade.generateContract(reservationId);

        model.addAttribute("contract", contract);

        return "contract";
    }
    @GetMapping("/admin/cars")
    public String adminCars(Model model) {
        model.addAttribute(
                "cars",
                rentalFacade.getAllCars()
                        .stream()
                        .map(CarMapper::toResponse)
                        .toList()
        );

        return "admin-cars";
    }
}