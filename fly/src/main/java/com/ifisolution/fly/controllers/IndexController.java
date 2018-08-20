package com.ifisolution.fly.controllers;

import com.ifisolution.fly.services.ReservationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    private ReservationService reservationService;

    @GetMapping({"", "/", "index"})
    public String getAllReservation(Model model) {
        model.addAttribute("reservations", reservationService.getReservations());
        return "Index";
    }
}
