package com.example.carrentalmanagementtmppp.model;


import com.example.carrentalmanagementtmppp.enums.ReservationStatus;
import com.example.carrentalmanagementtmppp.patterns.behavioral.state.*;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "reservations")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reservation implements ReservationContext {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "car_id")
    private Car car;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false)
    private LocalDate startDate;

    @Column(nullable = false)
    private LocalDate endDate;

    @Column(nullable = false)
    private Double totalPrice;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ReservationStatus status;

    @Column(nullable = false)
    private boolean gps;

    @Column(nullable = false)
    private boolean childSeat;

    @Column(nullable = false)
    private boolean insurance;

    @Column(nullable = false)
    private String packageType;

    private String assistanceLevel;

    private String optionsDescription;

    @Column(nullable = false)
    private String pickupLocation;

    @Transient
    private ReservationState state;

    public void initializeState() {
        switch (status) {
            case PENDING -> setState(new PendingState());
            case CONFIRMED -> setState(new ConfirmedState());
            case CANCELLED -> setState(new CancelledState());
            case COMPLETED -> setState(new CompletedState());
        }
    }

    @Override
    public void setState(ReservationState state) {
        this.state = state;
        this.state.setReservation(this);
    }

    public void confirm() {
        if (state == null) {
            initializeState();
        }
        state.confirm();
    }

    public void cancel() {
        if (state == null) {
            initializeState();
        }
        state.cancel();
    }

    public void complete() {
        if (state == null) {
            initializeState();
        }
        state.complete();
    }
}