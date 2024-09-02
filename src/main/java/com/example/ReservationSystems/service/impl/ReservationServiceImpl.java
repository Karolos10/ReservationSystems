package com.example.ReservationSystems.service.impl;

import com.example.ReservationSystems.dto.ReservationDTO;
import com.example.ReservationSystems.model.Business;
import com.example.ReservationSystems.model.Reservation;
import com.example.ReservationSystems.model.User;
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
    public ReservationDTO saveReservation(ReservationDTO reservationDTO) throws Exception {
        List<Reservation> reservations =
                reservationRepository.findReservations(
                        reservationDTO.getBusiness().getBusinessId(),
                        reservationDTO.getStartDate(),
                        reservationDTO.getEndDate(),
                        reservationDTO.getStartTime());
        if (reservations.isEmpty()) {
            if (reservationDTO.getReservationId() != null) {
                reservationDTO.setModificationDate(LocalDateTime.now());
            }
            Reservation reservationEntity = translateReservationDTOToReservation(reservationDTO);
            reservationEntity = reservationRepository.save(reservationEntity);
            reservationDTO.setReservationId(reservationEntity.getReservationId());
            return reservationDTO;
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

    private Reservation translateReservationDTOToReservation(ReservationDTO reservationDTO) {
        User user = new User();
        user.setUserId(reservationDTO.getUser().getUserId());
        Business business = new Business();
        business.setBusinessId(reservationDTO.getBusiness().getBusinessId());
        Reservation reservation = new Reservation();
        reservation.setModificationDate(reservationDTO.getModificationDate());
        reservation.setCanceled(reservationDTO.isCanceled());
        reservation.setBusiness(business);
        reservation.setStartDate(reservationDTO.getStartDate());
        reservation.setEndDate(reservationDTO.getEndDate());
        reservation.setStartTime(reservationDTO.getStartTime());
        reservation.setUser(user);
        reservation.setCreationDate(LocalDateTime.now());
        reservation.setDetails(reservationDTO.getDetails());
        return reservation;
    }
}
