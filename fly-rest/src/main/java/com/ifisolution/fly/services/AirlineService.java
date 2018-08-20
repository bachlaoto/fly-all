package com.ifisolution.fly.services;

import com.ifisolution.fly.domain.Airline;

import java.util.List;

public interface AirlineService {
    Airline finAirlineByID(Long id);

    List<Airline> findAllAirline();

    Airline saveAirline(Airline airline);

    void deleteAirline(Long id);
//    test merge
    // test merge 2
    // test merge 2
    // test merge 2
    // test merge 2
}
