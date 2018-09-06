package com.ifisolution.flyrest.services;

import com.ifisolution.flyrest.domain.FlightSchedule;

import java.util.List;

public interface FlightScheduleService {
    FlightSchedule saveFlightSchedule(FlightSchedule fightSchedule);

    List<FlightSchedule> getFlightSchedule();

    FlightSchedule findFlightScheduleById(Long id);

    void deleteFlightScheduleById(Long id);

//    FlightSchedule findByFlightScheduleIdAndAirlineId(Long flightScheduleId, Long airlineId);
}
