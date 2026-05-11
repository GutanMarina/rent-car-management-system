package com.example.carrentalmanagementtmppp.service;
import com.example.carrentalmanagementtmppp.model.Reservation;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ReservationService {
    Reservation createReservation(Long carId,
                                  Long userId,
                                  LocalDate startDate,
                                  LocalDate endDate,
                                  boolean gps,
                                  boolean childSeat,
                                  boolean insurance,
                                  String packageType,
                                  String pickupLocation);

    List<Reservation> getAllReservations();
    Optional<Reservation> getReservationById(Long id);
    List<Reservation> getReservationsByUserId(Long userId);

    Reservation confirmReservation(Long reservationId);
    Reservation cancelReservation(Long reservationId);
    Reservation completeReservation(Long reservationId);
}
