# Car Rental Management System

A full-stack Car Rental Management web application developed using Spring Boot and Thymeleaf.

The application simulates a real-world car rental platform where users can browse available cars, create reservations, perform payments, generate rental contracts, and manage their reservations. Administrators can manage vehicles, reservations, and monitor system activity through audit logs.

The project was developed following OOP and SOLID principles and integrates multiple GoF Design Patterns in a realistic business context.

---

## Technologies Used

- Java 21
- Spring Boot
- Spring Data JPA
- Hibernate
- Thymeleaf
- PostgreSQL
- Maven
- HTML / CSS / JavaScript
- JavaMailSender

---

## Main Features

### User Features
- User registration and login
- Browse available rental cars
- View detailed car information
- Create reservations
- Select rental packages and extra services
- Payment flow simulation
- Rental contract generation
- View personal reservations
- Receive email notifications

### Admin Features
- Manage cars
- View all reservations
- Complete or cancel reservations
- Monitor audit logs
- Track reservation events and system activity

---

## Implemented Design Patterns

### Creational Patterns

#### Singleton
Used for centralized configuration and shared system instances.

#### Builder
Used for flexible reservation object creation with optional services such as GPS, insurance, child seat, and rental packages.

#### Factory Method
Used for notification creation (email and SMS notifications).

#### Prototype
Used for rental contract generation through object cloning.

---

### Structural Patterns

#### Facade
`RentalFacade` provides a simplified interface that coordinates the reservation, payment, contract, and notification subsystems.

#### Proxy
`ReservationServiceProxy` controls access and logs reservation-related operations before delegating them to the real service.

#### Adapter
Used to integrate external payment processing logic into the internal application flow.

#### Composite
Used for grouping optional rental services and packages into unified service structures.

---

### Behavioral Patterns

#### Strategy
Used for dynamic pricing calculation depending on reservation type and rental conditions.

#### Observer
Used for reservation event notifications:
- email notifications
- SMS notifications
- audit log generation

#### State
Used for reservation lifecycle management:
- PENDING
- CONFIRMED
- COMPLETED
- CANCELLED

#### Chain of Responsibility
Used for sequential reservation validation and processing steps.

---

## Project Structure

```text
src/main/java/
├── controller
├── service
├── repository
├── model
├── dto
├── mapper
├── enums
├── patterns
```

---

## Authentication

The application uses session-based authentication with two user roles:
- USER
- ADMIN

---

## Notifications and Monitoring

The system supports:
- real email notifications using Gmail SMTP
- simulated SMS notifications
- audit log persistence in the database

---

## Future Improvements

- Spring Security integration
- JWT authentication
- Advanced filtering and search
- Better admin analytics
- Responsive UI improvements