package com.example.carrentalmanagementtmppp.service.impl;

import com.example.carrentalmanagementtmppp.enums.CarStatus;
import com.example.carrentalmanagementtmppp.enums.ReservationStatus;
import com.example.carrentalmanagementtmppp.model.Car;
import com.example.carrentalmanagementtmppp.model.Reservation;
import com.example.carrentalmanagementtmppp.model.User;
import com.example.carrentalmanagementtmppp.patterns.behavioral.chain.*;
import com.example.carrentalmanagementtmppp.patterns.behavioral.observer.ReservationSubject;
import com.example.carrentalmanagementtmppp.patterns.behavioral.strategy.LongTermPricingStrategy;
import com.example.carrentalmanagementtmppp.patterns.behavioral.strategy.PricingStrategy;
import com.example.carrentalmanagementtmppp.patterns.behavioral.strategy.StandardPricingStrategy;
import com.example.carrentalmanagementtmppp.patterns.behavioral.strategy.WeekendPricingStrategy;
import com.example.carrentalmanagementtmppp.patterns.creational.builder.DefaultReservationBuilder;
import com.example.carrentalmanagementtmppp.repository.CarRepository;
import com.example.carrentalmanagementtmppp.repository.ReservationRepository;
import com.example.carrentalmanagementtmppp.repository.UserRepository;
import com.example.carrentalmanagementtmppp.service.ReservationService;
import org.springframework.stereotype.Service;
import com.example.carrentalmanagementtmppp.patterns.creational.abstractFactory.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;
    private final CarRepository carRepository;
    private final UserRepository userRepository;
    private final ReservationSubject reservationSubject;

    public ReservationServiceImpl(ReservationRepository reservationRepository,
                                  CarRepository carRepository,
                                  UserRepository userRepository,
                                  ReservationSubject reservationSubject) {
        this.reservationRepository = reservationRepository;
        this.carRepository = carRepository;
        this.userRepository = userRepository;
        this.reservationSubject = reservationSubject;
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

        ReservationValidationContext validationContext =
                new ReservationValidationContext(carId, userId, startDate, endDate);

        ReservationValidationHandler carExistsHandler = new CarExistsValidationHandler(carRepository);
        ReservationValidationHandler userExistsHandler = new UserExistsValidationHandler(userRepository);
        ReservationValidationHandler carAvailabilityHandler = new CarAvailabilityValidationHandler(carRepository);
        ReservationValidationHandler datesValidationHandler = new ReservationDatesValidationHandler();

        carExistsHandler
                .setNext(userExistsHandler)
                .setNext(carAvailabilityHandler)
                .setNext(datesValidationHandler);

        carExistsHandler.handle(validationContext);

        Car car = carRepository.findById(carId)
                .orElseThrow(() -> new RuntimeException("Car not found"));

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        long days = ChronoUnit.DAYS.between(startDate, endDate);

        PricingStrategy pricingStrategy;

        if (days >= 7) {
            pricingStrategy = new LongTermPricingStrategy();
        } else if (startDate.getDayOfWeek().getValue() >= 6) {
            pricingStrategy = new WeekendPricingStrategy();
        } else {
            pricingStrategy = new StandardPricingStrategy();
        }

        double basePrice = pricingStrategy.calculatePrice(car, startDate, endDate);

        RentalPackageFactory rentalPackageFactory;
        if ("PREMIUM".equalsIgnoreCase(packageType)) {
            rentalPackageFactory = new PremiumRentalPackageFactory();
        } else {
            rentalPackageFactory = new StandardRentalPackageFactory();
            packageType = "STANDARD";
        }

        PackagePricingPolicy packagePricingPolicy = rentalPackageFactory.createPricingPolicy();
        PackageBenefits packageBenefits = rentalPackageFactory.createBenefits();
        AssistanceService assistanceService = rentalPackageFactory.createAssistanceService();

        boolean finalGps = gps || packageBenefits.hasIncludedGps();
        boolean finalInsurance = insurance || packageBenefits.hasIncludedInsurance();
        boolean finalChildSeat = childSeat;

        double packageAdjustedPrice = packagePricingPolicy.applyPackagePrice(basePrice);

        com.example.carrentalmanagementtmppp.patterns.structural.decorator.RentalComponent rentalComponent =
                new com.example.carrentalmanagementtmppp.patterns.structural.decorator.BaseRentalComponent(packageAdjustedPrice);

        if (finalGps) {
            rentalComponent = new com.example.carrentalmanagementtmppp.patterns.structural.decorator.GPSDecorator(rentalComponent);
        }
        if (finalChildSeat) {
            rentalComponent = new com.example.carrentalmanagementtmppp.patterns.structural.decorator.ChildSeatDecorator(rentalComponent);
        }
        if (finalInsurance) {
            rentalComponent = new com.example.carrentalmanagementtmppp.patterns.structural.decorator.InsuranceDecorator(rentalComponent);
        }

        double finalPrice = rentalComponent.getCost();
        String optionsDescription = rentalComponent.getDescription()
                + " | " + packageBenefits.getBenefitsDescription();

        DefaultReservationBuilder reservationBuilder = new DefaultReservationBuilder();

        Reservation reservation = reservationBuilder
                .setCar(car)
                .setUser(user)
                .setStartDate(startDate)
                .setEndDate(endDate)
                .setTotalPrice(finalPrice)
                .setStatus(ReservationStatus.PENDING)
                .setGps(finalGps)
                .setChildSeat(finalChildSeat)
                .setInsurance(finalInsurance)
                .setOptionsDescription(optionsDescription)
                .setPackageType(packageType.toUpperCase())
                .setAssistanceLevel(assistanceService.getSupportLevel())
                .setPickupLocation(pickupLocation)
                .build();

        car.setStatus(CarStatus.RESERVED);
        carRepository.save(car);

        return reservationRepository.save(reservation);
    }
    @Override
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public Optional<Reservation> getReservationById(Long id) {
        return reservationRepository.findById(id);
    }

    @Override
    public Reservation confirmReservation(Long reservationId) {
        Reservation reservation = reservationRepository.findById(reservationId)
                .orElseThrow(() -> new RuntimeException("Reservation not found"));

        reservation.initializeState();
        reservation.confirm();

        Reservation savedReservation = reservationRepository.save(reservation);
        reservationSubject.notifyObservers("RESERVATION_CONFIRMED", savedReservation);

        return savedReservation;
    }

    @Override
    public Reservation cancelReservation(Long reservationId) {
        Reservation reservation = reservationRepository.findById(reservationId)
                .orElseThrow(() -> new RuntimeException("Reservation not found"));

        reservation.initializeState();
        reservation.cancel();

        carRepository.save(reservation.getCar());
        Reservation savedReservation = reservationRepository.save(reservation);

        reservationSubject.notifyObservers("RESERVATION_CANCELLED", savedReservation);

        return savedReservation;
    }

    @Override
    public Reservation completeReservation(Long reservationId) {
        Reservation reservation = reservationRepository.findById(reservationId)
                .orElseThrow(() -> new RuntimeException("Reservation not found"));

        reservation.initializeState();
        reservation.complete();

        carRepository.save(reservation.getCar());
        Reservation savedReservation = reservationRepository.save(reservation);

        reservationSubject.notifyObservers("RESERVATION_COMPLETED", savedReservation);

        return savedReservation;
    }
    @Override
    public List<Reservation> getReservationsByUserId(Long userId) {
        return reservationRepository.findByUserId(userId);
    }
}