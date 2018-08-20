package com.ifisolution.fly.repositories;

import com.ifisolution.fly.domain.Airline;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirlineRepository extends JpaRepository<Airline, Long> {
}
