package com.example.carrentalmanagementtmppp.mapper;

import com.example.carrentalmanagementtmppp.dto.response.ReservationResponse;
import com.example.carrentalmanagementtmppp.model.Reservation;

public class ReservationMapper {

    private ReservationMapper() {
    }

    public static ReservationResponse toResponse(Reservation reservation) {
        return new ReservationResponse(
                reservation.getId(),

                reservation.getCar().getId(),
                reservation.getCar().getBrand() + " " + reservation.getCar().getModel(),
                reservation.getCar().getLicensePlate(),

                reservation.getUser().getId(),
                reservation.getUser().getFullName(),
                reservation.getUser().getEmail(),

                reservation.getStartDate(),
                reservation.getEndDate(),
                reservation.getPickupLocation(),

                reservation.getTotalPrice(),
                reservation.getStatus(),

                reservation.isGps(),
                reservation.isChildSeat(),
                reservation.isInsurance(),

                reservation.getOptionsDescription(),
                reservation.getPackageType(),
                reservation.getAssistanceLevel()
        );
    }
}
