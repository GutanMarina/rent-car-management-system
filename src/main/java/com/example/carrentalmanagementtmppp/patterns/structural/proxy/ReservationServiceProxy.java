package com.example.carrentalmanagementtmppp.patterns.structural.proxy;

import com.example.carrentalmanagementtmppp.model.Reservation;
import com.example.carrentalmanagementtmppp.service.ReservationService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@Primary
public class ReservationServiceProxy implements ReservationService {

    private final ReservationService realReservationService;

    public ReservationServiceProxy(com.example.carrentalmanagementtmppp.service.impl.ReservationServiceImpl realReservationService) {
        this.realReservationService = realReservationService;
    }

    @Override
    public Reservation createReservation(Long carId,
                                         Long userId,
                                         LocalDate startDate,
                                         LocalDate endDate,
                                         boolean gps,
                                         boolean childSeat,
                                         boolean insurance,
                                         String packageType) {
        System.out.println("[PROXY] Creating reservation for userId=" + userId +
                ", carId=" + carId +
                ", packageType=" + packageType);
        return realReservationService.createReservation(
                carId, userId, startDate, endDate, gps, childSeat, insurance, packageType
        );
    }

    @Override
    public List<Reservation> getAllReservations() {
        System.out.println("[PROXY] Fetching all reservations");
        return realReservationService.getAllReservations();
    }

    @Override
    public Optional<Reservation> getReservationById(Long id) {
        System.out.println("[PROXY] Fetching reservation with id=" + id);
        return realReservationService.getReservationById(id);
    }

    @Override
    public Reservation confirmReservation(Long reservationId) {
        System.out.println("[PROXY] Confirming reservation id=" + reservationId);
        return realReservationService.confirmReservation(reservationId);
    }

    @Override
    public Reservation cancelReservation(Long reservationId) {
        System.out.println("[PROXY] Cancelling reservation id=" + reservationId);
        return realReservationService.cancelReservation(reservationId);
    }

    @Override
    public Reservation completeReservation(Long reservationId) {
        System.out.println("[PROXY] Completing reservation id=" + reservationId);
        return realReservationService.completeReservation(reservationId);
    }
}