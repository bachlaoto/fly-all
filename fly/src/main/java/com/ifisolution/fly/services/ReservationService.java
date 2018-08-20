package com.ifisolution.fly.services;

import com.ifisolution.fly.domain.Reservation;

import java.util.List;


public interface ReservationService {
    List<Reservation> getReservations();
    Reservation findByFlightScheduleIdAndReservationId(Long flightScheduleId, Long reservationId);
    void deleteByID(Long reservationId, Long flightScheduleId);

}
