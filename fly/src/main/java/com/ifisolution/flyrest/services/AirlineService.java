package com.ifisolution.flyrest.services;

import com.ifisolution.flyrest.domain.Airline;

import java.util.List;

public interface AirlineService {
    Airline finAirlineByID(Long id);
    List<Airline> findAllAirline();
    Airline saveAirline(Airline airline);
    void deleteAirline(Long id);
}
