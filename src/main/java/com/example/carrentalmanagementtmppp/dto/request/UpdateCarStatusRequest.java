package com.example.carrentalmanagementtmppp.dto.request;
import com.example.carrentalmanagementtmppp.enums.CarStatus;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateCarStatusRequest {

    @NotNull(message = "Status is required")
    private CarStatus status;
}