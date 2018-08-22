package com.ifisolution.fly.controllers;

import com.ifisolution.fly.domain.Reservation;
import com.ifisolution.fly.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("reservation")
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    @GetMapping
    @RequestMapping("/{id}/show")
    public String showById(@PathVariable String id, Model model) {

        model.addAttribute("reservations", reservationService.findByID(new Long(id)));

        return "index";
    }

    @GetMapping("/new")
    public String newReservation(Model model) {
        model.addAttribute("reservation", new Reservation());

        return "reservationForm";
    }

    @GetMapping("/{id}/update")
    public String UpdateReservation(@PathVariable String id, Model model) {
        model.addAttribute("reservation", reservationService.findByID(Long.valueOf(id)));
        return "reservationForm";
    }

    @PostMapping("/reservation")
    public String saveOrUpdate(@ModelAttribute Reservation reservation) {
        Reservation savedReservation = reservationService.save(reservation);
        return "redirect:/reservation/" + savedReservation.getId() + "/show";
    }

    @GetMapping("{id}/delete")
    public String deleteReservationById(@PathVariable String id) {

        reservationService.deleteByID(Long.valueOf(id));
        return "redirect:/reservation";
    }

    @GetMapping(value = {"", "/", "index"})
    public String getAllReservation(Model model) {
        model.addAttribute("reservations", reservationService.getReservations());
        return "index";
    }


}

