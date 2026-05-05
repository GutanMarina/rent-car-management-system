package com.example.carrentalmanagementtmppp.repository;

import com.example.carrentalmanagementtmppp.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.carrentalmanagementtmppp.enums.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findByStatus(CarStatus status);
    List<Car> findByCarType(CarType carType);
    @Query("SELECT c FROM Car c WHERE LOWER(c.brand) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
            "OR LOWER(c.model) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Car> searchCars(@Param("keyword") String keyword);}