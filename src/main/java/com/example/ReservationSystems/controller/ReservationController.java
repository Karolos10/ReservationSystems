package com.example.ReservationSystems.controller;

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
    public Reservation saveReservation(@RequestBody Reservation reservation) throws Exception {
        return reservationService.saveReservation(reservation);
    }

    @PostMapping("/cancelar/{reservationId}")
    public boolean cancelReservation(@PathVariable("reservationId") Integer reservationId) {
        return reservationService.cancelReservation(reservationId);
    }

}
