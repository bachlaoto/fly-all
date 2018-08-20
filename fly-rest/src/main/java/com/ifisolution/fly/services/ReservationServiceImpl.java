package com.ifisolution.fly.services;

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
    @Autowired
    private ReservationRepository reservationRepository;

    @Override
    public List<Reservation> getReservations() {
        List<Reservation> reservations = reservationRepository.findAll();
        return reservations;
    }

    @Override
    public Reservation findByID(Long id) {
        Optional<Reservation> reservationOptional = reservationRepository.findById(id);
        return reservationOptional.get();
    }

    @Override
    public void deleteByID(Long reservationId) {
        reservationRepository.deleteById(reservationId);
    }

    @Override
    public Reservation save(Reservation reservation) {
        return reservationRepository.save(reservation);
    }
}


