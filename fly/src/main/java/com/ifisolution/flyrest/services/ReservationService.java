package com.ifisolution.flyrest.services;

import com.ifisolution.flyrest.domain.Reservation;

import java.util.List;


public interface ReservationService {
    List<Reservation> getReservations();
    Reservation findByFlightScheduleIdAndReservationId(Long flightScheduleId, Long reservationId);
    void deleteByID(Long reservationId, Long flightScheduleId);

}
