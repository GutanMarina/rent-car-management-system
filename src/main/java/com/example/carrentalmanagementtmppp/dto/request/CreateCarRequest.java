package com.example.carrentalmanagementtmppp.dto.request;

import com.example.carrentalmanagementtmppp.enums.CarStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;
import com.example.carrentalmanagementtmppp.enums.CarType;
import com.example.carrentalmanagementtmppp.enums.FuelType;
import com.example.carrentalmanagementtmppp.enums.TransmissionType;
import jakarta.validation.constraints.Min;

@Getter
@Setter
public class CreateCarRequest {

    @NotBlank(message = "Brand is required")
    private String brand;

    @NotBlank(message = "Model is required")
    private String model;

    @NotBlank(message = "License plate is required")
    private String licensePlate;

    @NotNull(message = "Price per day is required")
    @Positive(message = "Price per day must be positive")
    private Double pricePerDay;

    private CarStatus status = CarStatus.AVAILABLE;
    @NotNull(message = "Car type is required")
    private CarType carType;

    @NotNull(message = "Number of seats is required")
    @Min(value = 1, message = "Seats must be at least 1")
    private Integer seats;

    @NotNull(message = "Fuel type is required")
    private FuelType fuelType;

    @NotNull(message = "Transmission type is required")
    private TransmissionType transmissionType;

    private String imageUrl;
}