package com.example.carrentalmanagementtmppp.patterns.structural.facade;

import com.example.carrentalmanagementtmppp.enums.CarStatus;
import com.example.carrentalmanagementtmppp.model.Car;
import com.example.carrentalmanagementtmppp.model.Payment;
import com.example.carrentalmanagementtmppp.model.Reservation;
import com.example.carrentalmanagementtmppp.model.User;
import com.example.carrentalmanagementtmppp.patterns.creational.prototype.RentalContract;
import com.example.carrentalmanagementtmppp.enums.CarType;

import java.time.LocalDate;
import java.util.List;

public interface RentalFacade {

    Car addCar(Car car);
    List<Car> getAllCars();
    Car getCarById(Long id);

    User addUser(User user);
    List<User> getAllUsers();
    User getUserById(Long id);

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
    Reservation getReservationById(Long id);

    Reservation confirmReservation(Long reservationId);
    Reservation cancelReservation(Long reservationId);
    Reservation completeReservation(Long reservationId);


    Payment createPayment(Long reservationId, String paymentMethod);
    List<Payment> getAllPayments();
    Payment getPaymentById(Long id);

    RentalContract generateContract(Long reservationId);
    List<Car> getAvailableCars();
    List<Car> getCarsByType(CarType carType);
    List<Car> searchCars(String keyword);
    void deleteCar(Long id);
    Car updateCarStatus(Long id, CarStatus status);
    List<Reservation> getReservationsByUserId(Long userId);}
