package com.ifisolution.flyrest.services;

import com.ifisolution.flyrest.domain.FlightSchedule;
import com.ifisolution.flyrest.repositories.FlightScheduleRepository;
import com.ifisolution.flyrest.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightScheduleServiceImpl implements FlightScheduleService {
    @Autowired
    private FlightScheduleRepository flightScheduleRepository;

    public FlightScheduleServiceImpl(FlightScheduleRepository flightScheduleRepository, ReservationRepository reservationRepository) {
        this.flightScheduleRepository = flightScheduleRepository;
    }

    @Override
    public FlightSchedule saveFlightSchedule(FlightSchedule flightSchedule) {
        return flightScheduleRepository.save(flightSchedule);
    }

    @Override
    public List<FlightSchedule> getFlightSchedule() {
        List<FlightSchedule> listFlightSchedule = flightScheduleRepository.findAll();

        return listFlightSchedule;
    }
}
