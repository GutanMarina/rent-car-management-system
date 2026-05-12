package com.example.carrentalmanagementtmppp.controller;

import com.example.carrentalmanagementtmppp.enums.UserRole;
import com.example.carrentalmanagementtmppp.model.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.ui.Model;
import com.example.carrentalmanagementtmppp.mapper.CarMapper;
import com.example.carrentalmanagementtmppp.patterns.structural.facade.RentalFacade;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.carrentalmanagementtmppp.mapper.ReservationMapper;
import com.example.carrentalmanagementtmppp.patterns.creational.prototype.RentalContract;
import com.example.carrentalmanagementtmppp.mapper.AuditLogMapper;

@Controller
public class HomeController {

    private final RentalFacade rentalFacade;

    public HomeController(RentalFacade rentalFacade) {
        this.rentalFacade = rentalFacade;
    }

    private void addLoggedUserToModel(Model model, HttpSession session) {
        User loggedUser = (User) session.getAttribute("loggedUser");
        model.addAttribute("loggedUser", loggedUser);
    }

    @GetMapping("/")
    public String home(Model model, HttpSession session) {
        addLoggedUserToModel(model, session);

        model.addAttribute(
                "cars",
                rentalFacade.getAvailableCars()
                        .stream()
                        .map(CarMapper::toResponse)
                        .toList()
        );

        return "index";
    }

    @GetMapping("/cars-page/{id}")
    public String carDetails(@PathVariable Long id, Model model, HttpSession session) {
        addLoggedUserToModel(model, session);

        model.addAttribute(
                "car",
                CarMapper.toResponse(rentalFacade.getCarById(id))
        );

        return "car-details";
    }

    @GetMapping("/reservation-page/{id}")
    public String reservationDetails(@PathVariable Long id, Model model, HttpSession session) {
        addLoggedUserToModel(model, session);

        model.addAttribute(
                "reservation",
                ReservationMapper.toResponse(rentalFacade.getReservationById(id))
        );

        return "reservation-details";
    }

    @GetMapping("/payment-page/{reservationId}")
    public String paymentPage(@PathVariable Long reservationId, Model model, HttpSession session) {
        addLoggedUserToModel(model, session);

        model.addAttribute(
                "reservation",
                ReservationMapper.toResponse(rentalFacade.getReservationById(reservationId))
        );

        return "payment";
    }

    @GetMapping("/contract-page/{reservationId}")
    public String contractPage(@PathVariable Long reservationId, Model model, HttpSession session) {
        addLoggedUserToModel(model, session);

        RentalContract contract = rentalFacade.generateContract(reservationId);
        model.addAttribute("contract", contract);

        return "contract";
    }

    @GetMapping("/admin/cars")
    public String adminCars(Model model, HttpSession session) {
        User loggedUser = (User) session.getAttribute("loggedUser");

        if (loggedUser == null) {
            return "redirect:/login";
        }

        if (loggedUser.getRole() != UserRole.ADMIN) {
            return "redirect:/";
        }

        addLoggedUserToModel(model, session);

        model.addAttribute(
                "cars",
                rentalFacade.getAllCars()
                        .stream()
                        .map(CarMapper::toResponse)
                        .toList()
        );

        return "admin-cars";
    }
    @GetMapping("/my-reservations")
    public String myReservations(Model model, HttpSession session) {
        User loggedUser = (User) session.getAttribute("loggedUser");

        if (loggedUser == null) {
            return "redirect:/login";
        }

        addLoggedUserToModel(model, session);

        model.addAttribute(
                "reservations",
                rentalFacade.getReservationsByUserId(loggedUser.getId())
                        .stream()
                        .map(ReservationMapper::toResponse)
                        .toList()
        );

        return "my-reservations";
    }

    @GetMapping("/admin/reservations")
    public String adminReservations(Model model, HttpSession session) {
        User loggedUser = (User) session.getAttribute("loggedUser");

        if (loggedUser == null) {
            return "redirect:/login";
        }

        if (loggedUser.getRole() != UserRole.ADMIN) {
            return "redirect:/";
        }

        addLoggedUserToModel(model, session);

        model.addAttribute(
                "reservations",
                rentalFacade.getAllReservations()
                        .stream()
                        .map(ReservationMapper::toResponse)
                        .toList()
        );

        return "admin-reservations";
    }
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }
    @GetMapping("/admin/audit-logs")
    public String adminAuditLogs(Model model, HttpSession session) {
        User loggedUser = (User) session.getAttribute("loggedUser");

        if (loggedUser == null) {
            return "redirect:/login";
        }

        if (loggedUser.getRole() != UserRole.ADMIN) {
            return "redirect:/";
        }

        addLoggedUserToModel(model, session);

        model.addAttribute(
                "auditLogs",
                rentalFacade.getAllAuditLogs()
                        .stream()
                        .map(AuditLogMapper::toResponse)
                        .toList()
        );

        return "admin-audit-logs";
    }
}