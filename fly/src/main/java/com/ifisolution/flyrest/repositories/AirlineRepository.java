package com.ifisolution.flyrest.repositories;

import com.ifisolution.flyrest.domain.Airline;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirlineRepository extends JpaRepository<Airline, Long> {
}
