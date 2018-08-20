package com.ifisolution.fly.services;

import com.ifisolution.fly.domain.FlightSchedule;
import com.ifisolution.fly.repositories.FlightScheduleRepository;
import com.ifisolution.fly.repositories.ReservationRepository;
import org.springframework.stereotype.Service;

@Service
public class FlightScheduleServiceImpl implements  FlightScheduleService {
    private FlightScheduleRepository flightScheduleRepository;

    public FlightScheduleServiceImpl(FlightScheduleRepository flightScheduleRepository, ReservationRepository reservationRepository) {
        this.flightScheduleRepository = flightScheduleRepository;
    }

    @Override
    public FlightSchedule saveFlightSchedule(FlightSchedule flightSchedule) {
        return flightScheduleRepository.save(flightSchedule);
    }

}
