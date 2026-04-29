package com.example.carrentalmanagementtmppp.repository;

import com.example.carrentalmanagementtmppp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
