package com.example.carrentalmanagementtmppp.model;

import com.example.carrentalmanagementtmppp.enums.CarStatus;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "cars")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String brand;

    @Column(nullable = false)
    private String model;

    @Column(nullable = false, unique = true)
    private String licensePlate;

    @Column(nullable = false)
    private Double pricePerDay;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CarStatus status;
}