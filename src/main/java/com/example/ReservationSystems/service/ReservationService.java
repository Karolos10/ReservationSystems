package com.example.ReservationSystems.service;

import com.example.ReservationSystems.dto.ReservationDTO;
import com.example.ReservationSystems.model.Reservation;

import java.util.List;

public interface ReservationService {

    List<Reservation> getReservations(Integer userId);

    ReservationDTO saveReservation(ReservationDTO reservation) throws Exception;

    boolean cancelReservation(Integer reservationId);

}
