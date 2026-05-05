package com.example.carrentalmanagementtmppp.mapper;

import com.example.carrentalmanagementtmppp.dto.response.CarResponse;
import com.example.carrentalmanagementtmppp.model.Car;

public class CarMapper {

    private CarMapper() {
    }

    public static CarResponse toResponse(Car car) {
        return new CarResponse(
                car.getId(),
                car.getBrand(),
                car.getModel(),
                car.getLicensePlate(),
                car.getPricePerDay(),
                car.getStatus(),
                car.getCarType(),
                car.getSeats(),
                car.getFuelType(),
                car.getTransmissionType(),
                car.getImageUrl()
        );
    }
}
