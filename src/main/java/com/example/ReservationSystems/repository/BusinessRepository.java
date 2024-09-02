package com.example.ReservationSystems.repository;

import com.example.ReservationSystems.model.Business;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusinessRepository extends JpaRepository<Business, Integer> {
}
