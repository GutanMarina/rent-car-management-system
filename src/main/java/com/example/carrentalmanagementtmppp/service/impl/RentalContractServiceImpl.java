package com.example.carrentalmanagementtmppp.service.impl;

import com.example.carrentalmanagementtmppp.model.Reservation;
import com.example.carrentalmanagementtmppp.patterns.creational.prototype.RentalContract;
import com.example.carrentalmanagementtmppp.patterns.creational.prototype.RentalContractRegistry;
import com.example.carrentalmanagementtmppp.repository.ReservationRepository;
import com.example.carrentalmanagementtmppp.service.RentalContractService;
import org.springframework.stereotype.Service;

@Service
public class RentalContractServiceImpl implements RentalContractService {

    private final ReservationRepository reservationRepository;
    private final RentalContractRegistry rentalContractRegistry;

    public RentalContractServiceImpl(ReservationRepository reservationRepository,
                                     RentalContractRegistry rentalContractRegistry) {
        this.reservationRepository = reservationRepository;
        this.rentalContractRegistry = rentalContractRegistry;
    }

    @Override
    public RentalContract generateContract(Long reservationId) {
        Reservation reservation = reservationRepository.findById(reservationId)
                .orElseThrow(() -> new RuntimeException("Reservation not found"));

        String packageType = reservation.getPackageType() != null ? reservation.getPackageType() : "STANDARD";

        RentalContract contract = rentalContractRegistry.getTemplate(packageType);

        contract.setReservationId(reservation.getId());
        contract.setCustomerName(reservation.getUser().getFullName());
        contract.setCarDetails(reservation.getCar().getBrand() + " " + reservation.getCar().getModel()
                + " (" + reservation.getCar().getLicensePlate() + ")");
        contract.setAdditionalNotes(contract.getAdditionalNotes()
                + " | Reservation period: " + reservation.getStartDate() + " to " + reservation.getEndDate()
                + " | Options: " + reservation.getOptionsDescription());

        return contract;
    }
}
