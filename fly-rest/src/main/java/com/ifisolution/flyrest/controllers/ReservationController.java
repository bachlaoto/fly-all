package com.ifisolution.flyrest.controllers;

import com.ifisolution.flyrest.domain.Reservation;
import com.ifisolution.flyrest.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("reservation")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    @GetMapping("/{id}/show")
    public Reservation showById(@PathVariable String id) {

        return reservationService.findByID(new Long(id));
    }

    @PostMapping("/new")
    public Reservation UpdateReservation(@Valid @RequestBody Reservation reservation) {
        return reservationService.save(reservation);
    }

    @PutMapping("/{id}/update")
//    public Reservation newReservation(@PathVariable Long id) {
//        Reservation reservationTemp = reservationService.findByID(new Long(id));
////        if (reservationTemp != null) {
//            return reservationService.save(reservationTemp);
////        }
////        reservationService.save(reservationTemp);
////        return reservationTemp;
//    }
    public ResponseEntity<Reservation> updateContact(@PathVariable(value = "id") Long reservationId,
                                                     @Valid @RequestBody Reservation reservation) {
        Reservation reservation1 = reservationService.findByID(reservationId);
        if (reservation == null) {
            return ResponseEntity.notFound().build();
        }
//        reservation.setName(reservationForm.getName());
//        reservation.setAge(reservationForm.getAge());

        Reservation updatedReservation = reservationService.save(reservation);
        return ResponseEntity.ok(updatedReservation);
    }

    @DeleteMapping("{id}/delete")
    public void deleteReservationById(@PathVariable String id) {
        reservationService.deleteByID(Long.valueOf(id));
    }

    @GetMapping(value = {"", "/", "index"})
    public ResponseEntity<List<Reservation>> getAllReservation() {
        List<Reservation> reservationList = reservationService.getReservations();
        if (reservationList.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(reservationList, HttpStatus.OK);

    }
}