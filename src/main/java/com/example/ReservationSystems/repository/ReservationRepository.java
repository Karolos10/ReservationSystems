package com.example.ReservationSystems.repository;

import com.example.ReservationSystems.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

    @Query(
            nativeQuery = true,
            value = "SELECT " +
                    "    reservation_id, " +
                    "    canceled, " +
                    "    creation_date, " +
                    "    details, " +
                    "    end_date, " +
                    "    modification_date, " +
                    "    start_date, " +
                    "    start_time, " +
                    "    business_id, " +
                    "    user_id " +
                    "FROM " +
                    "    bookingsystems.reservations r " +
                    "WHERE " +
                    "    r.user_id = :userId " +
                    "    AND r.canceled = false")
    List<Reservation> findActiveReservationsByUserId(@Param("userId") Integer userId);

    @Query(
            nativeQuery = true,
            value = "SELECT " +
                    "    reservation_id, " +
                    "    canceled, " +
                    "    creation_date, " +
                    "    details, " +
                    "    end_date, " +
                    "    modification_date, " +
                    "    start_date, " +
                    "    start_time, " +
                    "    business_id, " +
                    "    user_id " +
                    "FROM " +
                    "    bookingsystems.reservations " +
                    "WHERE " +
                    "    business_id = :businessId " +
                    "    AND (" +
                    "        (start_date BETWEEN :startDate AND :endDate)" +
                    "        OR (end_date BETWEEN :startDate AND :endDate)" +
                    "    )" +
                    "    AND (" +
                    "        :startTime IS NULL " +
                    "        OR start_time = :startTime" +
                    "    )" +
                    "    AND canceled = false")
    List<Reservation> findActiveReservations(
            @Param("businessId") Integer businessId,
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate,
            @Param("startTime") LocalTime startTime);
}