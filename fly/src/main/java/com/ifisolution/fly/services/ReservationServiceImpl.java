package com.ifisolution.fly.services;

import com.ifisolution.fly.domain.FlightSchedule;
import com.ifisolution.fly.domain.Reservation;
import com.ifisolution.fly.repositories.FlightScheduleRepository;
import com.ifisolution.fly.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService {
    @Autowired
    private FlightScheduleRepository flightScheduleRepository;
    private ReservationRepository reservationRepository;

    @Override
    public Reservation findByFlightScheduleIdAndReservationId(Long flightScheduleId, Long reservationId) {

        Optional<FlightSchedule> flightScheduleOptional = flightScheduleRepository.findById(flightScheduleId);
        FlightSchedule flightSchedule = flightScheduleOptional.get();
        Optional<Reservation> reservationOptional = flightSchedule.getReservations().stream().filter(reservation -> reservation.getId().equals(reservationId)).findFirst();
        return reservationOptional.get();

    }

    @Override
    public List<Reservation> getReservations() {
        List<Reservation> reservations = reservationRepository.findAll();
        return reservations;
    }

    @Override
    public void deleteByID(Long reservationId, Long flightScheduleId) {
        Optional<FlightSchedule> flightScheduleOptional = flightScheduleRepository.findById(flightScheduleId);
        FlightSchedule flightSchedule = flightScheduleOptional.get();

        Optional<Reservation> reservationOptional = flightSchedule.getReservations().stream().filter(reservation -> reservation.getId().equals(reservationId)).findFirst();


        Reservation reservationToDelete = reservationOptional.get();
        reservationToDelete.setFlightSchedule(null);
        flightSchedule.getReservations().remove(reservationOptional.get());
        flightScheduleRepository.save(flightSchedule);
    }
}

