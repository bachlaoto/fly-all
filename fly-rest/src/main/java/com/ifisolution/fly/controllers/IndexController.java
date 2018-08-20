package com.ifisolution.fly.controllers;

import com.ifisolution.fly.domain.Reservation;
import com.ifisolution.fly.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class IndexController {
    @Autowired
    private ReservationService reservationService;

    @GetMapping(value = {"", "/", "index"})
    public List<Reservation> getAllReservation() {
        return reservationService.getReservations();
    }
}
