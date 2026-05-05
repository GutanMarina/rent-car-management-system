package com.example.carrentalmanagementtmppp.controller;
import com.example.carrentalmanagementtmppp.dto.request.CreateReservationRequest;
import com.example.carrentalmanagementtmppp.dto.response.ReservationResponse;
import com.example.carrentalmanagementtmppp.mapper.ReservationMapper;
import com.example.carrentalmanagementtmppp.model.Reservation;
import com.example.carrentalmanagementtmppp.patterns.structural.facade.RentalFacade;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    private final RentalFacade rentalFacade;

    public ReservationController(RentalFacade rentalFacade) {
        this.rentalFacade = rentalFacade;
    }

    @PostMapping
    public ReservationResponse createReservation(@Valid @RequestBody CreateReservationRequest request) {
        Reservation reservation = rentalFacade.createReservation(
                request.getCarId(),
                request.getUserId(),
                request.getStartDate(),
                request.getEndDate(),
                request.isGps(),
                request.isChildSeat(),
                request.isInsurance(),
                request.getPackageType()
        );

        return ReservationMapper.toResponse(reservation);
    }

    @GetMapping
    public List<ReservationResponse> getAllReservations() {
        return rentalFacade.getAllReservations()
                .stream()
                .map(ReservationMapper::toResponse)
                .toList();
    }

    @GetMapping("/{id}")
    public ReservationResponse getReservationById(@PathVariable Long id) {
        Reservation reservation = rentalFacade.getReservationById(id);
        return ReservationMapper.toResponse(reservation);
    }

    @PutMapping("/{id}/confirm")
    public ReservationResponse confirmReservation(@PathVariable Long id) {
        Reservation reservation = rentalFacade.confirmReservation(id);
        return ReservationMapper.toResponse(reservation);
    }

    @PutMapping("/{id}/cancel")
    public ReservationResponse cancelReservation(@PathVariable Long id) {
        Reservation reservation = rentalFacade.cancelReservation(id);
        return ReservationMapper.toResponse(reservation);
    }

    @PutMapping("/{id}/complete")
    public ReservationResponse completeReservation(@PathVariable Long id) {
        Reservation reservation = rentalFacade.completeReservation(id);
        return ReservationMapper.toResponse(reservation);
    }
}