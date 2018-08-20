package com.ifisolution.flyrest.services;

import com.ifisolution.flyrest.domain.FlightSchedule;
import com.ifisolution.flyrest.repositories.FlightScheduleRepository;
import com.ifisolution.flyrest.repositories.ReservationRepository;
import org.springframework.stereotype.Service;

@Service
public class FlightScheduleServiceImpl implements FlightScheduleService {
    private FlightScheduleRepository flightScheduleRepository;

    public FlightScheduleServiceImpl(FlightScheduleRepository flightScheduleRepository, ReservationRepository reservationRepository) {
        this.flightScheduleRepository = flightScheduleRepository;
    }

    @Override
    public FlightSchedule saveFlightSchedule(FlightSchedule flightSchedule) {
        return flightScheduleRepository.save(flightSchedule);
    }

}
