package com.example.carrentalmanagementtmppp.dto.response;

import com.example.carrentalmanagementtmppp.enums.CarStatus;
import com.example.carrentalmanagementtmppp.enums.CarType;
import com.example.carrentalmanagementtmppp.enums.FuelType;
import com.example.carrentalmanagementtmppp.enums.TransmissionType;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CarResponse {

    private Long id;
    private String brand;
    private String model;
    private String licensePlate;
    private Double pricePerDay;
    private CarStatus status;

    private CarType carType;
    private Integer seats;
    private FuelType fuelType;
    private TransmissionType transmissionType;
    private String imageUrl;
}
