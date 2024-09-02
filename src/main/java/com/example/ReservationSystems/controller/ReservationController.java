package com.example.ReservationSystems.controller;

import com.example.ReservationSystems.dto.ReservationDTO;
import com.example.ReservationSystems.model.Reservation;
import com.example.ReservationSystems.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    ReservationService reservationService;

    @GetMapping("/{userId}")
    public List<Reservation> getReservations(@PathVariable("userId") Integer userId) {
        return reservationService.getReservations(userId);


    }

    @PostMapping
    public ReservationDTO saveReservation(@RequestBody ReservationDTO reservation) throws Exception {
        return reservationService.saveReservation(reservation);
    }

    @PutMapping("/cancelar")
    public boolean cancelReservation(@RequestBody ReservationDTO reservationDTO) {
        return reservationService.cancelReservation(reservationDTO.getReservationId());
    }

}
