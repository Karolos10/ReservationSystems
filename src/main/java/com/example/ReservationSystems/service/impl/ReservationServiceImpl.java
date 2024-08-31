package com.example.ReservationSystems.service.impl;

import com.example.ReservationSystems.model.Reservation;
import com.example.ReservationSystems.repository.ReservationRepository;
import com.example.ReservationSystems.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    ReservationRepository reservationRepository;

    @Override
    public List<Reservation> getReservations(Integer userId) {
        return reservationRepository.findByUserId(userId);
    }

    @Override
    public Reservation saveReservation(Reservation reservation) throws Exception {
        List<Reservation> reservations =
                reservationRepository.findReservations(
                        reservation.getBusiness().getBusinessId(),
                        reservation.getStartDate(),
                        reservation.getEndDate(),
                        reservation.getStartTime());
        if (reservations.isEmpty()) {
            if (reservation.getReservationId() != null) {
                reservation.setModificationDate(LocalDateTime.now());
            }
            return reservationRepository.save(reservation);
        } else {
            throw new Exception("La reserva se cruza con otra");
        }
    }

    @Override
    public boolean cancelReservation(Integer reservationId) {
        Optional<Reservation> optionalReservation = reservationRepository.findById(reservationId);
        if (optionalReservation.isPresent()) {
            Reservation result = optionalReservation.get();
            result.setCanceled(true);
            reservationRepository.save(result);
            return true;
        }
        return false;
    }
}
