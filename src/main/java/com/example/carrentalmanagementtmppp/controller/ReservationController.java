package com.example.carrentalmanagementtmppp.controller;
import com.example.carrentalmanagementtmppp.model.Reservation;
import com.example.carrentalmanagementtmppp.patterns.structural.facade.RentalFacade;
import com.example.carrentalmanagementtmppp.service.ReservationService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    private final RentalFacade rentalFacade;

    public ReservationController(RentalFacade rentalFacade) {
        this.rentalFacade = rentalFacade;
    }

    @PostMapping
    public Reservation createReservation(@RequestParam Long carId,
                                         @RequestParam Long userId,
                                         @RequestParam String startDate,
                                         @RequestParam String endDate,
                                         @RequestParam(defaultValue = "false") boolean gps,
                                         @RequestParam(defaultValue = "false") boolean childSeat,
                                         @RequestParam(defaultValue = "false") boolean insurance,
                                         @RequestParam(defaultValue = "STANDARD") String packageType) {
        return rentalFacade.createReservation(
                carId,
                userId,
                LocalDate.parse(startDate),
                LocalDate.parse(endDate),
                gps,
                childSeat,
                insurance,
                packageType
        );
    }

    @GetMapping
    public List<Reservation> getAllReservations() {
        return rentalFacade.getAllReservations();
    }

    @GetMapping("/{id}")
    public Reservation getReservationById(@PathVariable Long id) {
        return rentalFacade.getReservationById(id);
    }

    @PutMapping("/{id}/confirm")
    public Reservation confirmReservation(@PathVariable Long id) {
        return rentalFacade.confirmReservation(id);
    }

    @PutMapping("/{id}/cancel")
    public Reservation cancelReservation(@PathVariable Long id) {
        return rentalFacade.cancelReservation(id);
    }

    @PutMapping("/{id}/complete")
    public Reservation completeReservation(@PathVariable Long id) {
        return rentalFacade.completeReservation(id);
    }
}