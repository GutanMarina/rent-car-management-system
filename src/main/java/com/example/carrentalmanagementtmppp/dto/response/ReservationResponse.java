package com.example.carrentalmanagementtmppp.dto.response;

import com.example.carrentalmanagementtmppp.enums.ReservationStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class ReservationResponse {

    private Long id;

    private Long carId;
    private String carName;
    private String licensePlate;

    private Long userId;
    private String userName;
    private String userEmail;

    private LocalDate startDate;
    private LocalDate endDate;

    private Double totalPrice;
    private ReservationStatus status;

    private boolean gps;
    private boolean childSeat;
    private boolean insurance;

    private String optionsDescription;
    private String packageType;
    private String assistanceLevel;
}
