package com.ifisolution.flyrest.services;

import com.ifisolution.flyrest.domain.Reservation;

import java.util.List;


public interface ReservationService {
    List<Reservation> getReservations();

    void deleteByID(Long reservationId);

    Reservation findByID(Long id);

    Reservation save(Reservation reservation);
}
