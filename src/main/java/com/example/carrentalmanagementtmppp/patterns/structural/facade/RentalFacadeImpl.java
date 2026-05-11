package com.example.carrentalmanagementtmppp.patterns.structural.facade;

import com.example.carrentalmanagementtmppp.enums.CarStatus;
import com.example.carrentalmanagementtmppp.enums.CarType;
import com.example.carrentalmanagementtmppp.model.Car;
import com.example.carrentalmanagementtmppp.model.Payment;
import com.example.carrentalmanagementtmppp.model.Reservation;
import com.example.carrentalmanagementtmppp.model.User;
import com.example.carrentalmanagementtmppp.patterns.creational.prototype.RentalContract;
import com.example.carrentalmanagementtmppp.service.*;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class RentalFacadeImpl implements RentalFacade {

    private final CarService carService;
    private final UserService userService;
    private final ReservationService reservationService;
    private final PaymentService paymentService;
    private final RentalContractService rentalContractService;

    public RentalFacadeImpl(CarService carService,
                            UserService userService,
                            ReservationService reservationService,
                            PaymentService paymentService,
                            RentalContractService rentalContractService) {
        this.carService = carService;
        this.userService = userService;
        this.reservationService = reservationService;
        this.paymentService = paymentService;
        this.rentalContractService = rentalContractService;
    }

    @Override
    public Car addCar(Car car) {
        return carService.saveCar(car);
    }

    @Override
    public Car getCarById(Long id) {
        return carService.getCarById(id)
                .orElseThrow(() -> new RuntimeException("Car not found"));
    }

    @Override
    public User addUser(User user) {
        return userService.saveUser(user);
    }

    @Override
    public List<Car> getAllCars() {
        return carService.getAllCars();
    }

    @Override
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @Override
    public User getUserById(Long id) {
        return userService.getUserById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public List<Reservation> getAllReservations() {
        return reservationService.getAllReservations();
    }

    @Override
    public Reservation createReservation(Long carId,
                                         Long userId,
                                         LocalDate startDate,
                                         LocalDate endDate,
                                         boolean gps,
                                         boolean childSeat,
                                         boolean insurance,
                                         String packageType,
                                         String pickupLocation) {
        return reservationService.createReservation(
                carId,
                userId,
                startDate,
                endDate,
                gps,
                childSeat,
                insurance,
                packageType,
                pickupLocation
        );
    }
    @Override
    public List<Reservation> getReservationsByUserId(Long userId) {
        return reservationService.getReservationsByUserId(userId);
    }

    @Override
    public Reservation confirmReservation(Long reservationId) {
        return reservationService.confirmReservation(reservationId);
    }

    @Override
    public Reservation cancelReservation(Long reservationId) {
        return reservationService.cancelReservation(reservationId);
    }

    @Override
    public Reservation completeReservation(Long reservationId) {
        return reservationService.completeReservation(reservationId);
    }

    @Override
    public Reservation getReservationById(Long id) {
        return reservationService.getReservationById(id)
                .orElseThrow(() -> new RuntimeException("Reservation not found"));
    }

    @Override
    public Payment createPayment(Long reservationId, String paymentMethod) {
        return paymentService.createPayment(reservationId, paymentMethod);
    }

    @Override
    public List<Payment> getAllPayments() {
        return paymentService.getAllPayments();
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentService.getPaymentById(id)
                .orElseThrow(() -> new RuntimeException("Payment not found"));
    }

    @Override
    public RentalContract generateContract(Long reservationId) {
        return rentalContractService.generateContract(reservationId);
    }

    @Override
    public List<Car> getAvailableCars() {
        return carService.getAvailableCars();
    }

    @Override
    public List<Car> getCarsByType(CarType carType) {
        return carService.getCarsByType(carType);
    }

    @Override
    public List<Car> searchCars(String keyword) {
        return carService.searchCars(keyword);
    }

    @Override
    public void deleteCar(Long id) {
        carService.deleteCar(id);
    }

    @Override
    public Car updateCarStatus(Long id, CarStatus status) {
        return carService.updateCarStatus(id, status);
    }
}
