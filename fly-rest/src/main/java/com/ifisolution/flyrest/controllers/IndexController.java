package com.ifisolution.flyrest.controllers;

import com.ifisolution.flyrest.domain.Reservation;
import com.ifisolution.flyrest.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)

public class IndexController {
    @Autowired
    private ReservationService reservationService;

    @GetMapping(value = {"", "/", "index"})
    public List<Reservation> getAllReservation() {
        return reservationService.getReservations();
    }
}
