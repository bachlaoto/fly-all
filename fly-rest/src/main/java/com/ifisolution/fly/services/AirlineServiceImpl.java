package com.ifisolution.fly.services;

import com.ifisolution.fly.domain.Airline;
import com.ifisolution.fly.repositories.AirlineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AirlineServiceImpl implements AirlineService {
    @Autowired
    private AirlineRepository airlineRepository;

    @Override
    public Airline finAirlineByID(Long id) {
        Optional<Airline> airlineOptional = airlineRepository.findById(id);
        return airlineOptional.get();
    }

    @Override
    public List<Airline> findAllAirline() {
        return airlineRepository.findAll();
    }

    @Override
    public Airline saveAirline(Airline airline) {
        return airlineRepository.save(airline);
    }

    @Override
    public void deleteAirline(Long id) {
        airlineRepository.deleteById(id);
    }
}
