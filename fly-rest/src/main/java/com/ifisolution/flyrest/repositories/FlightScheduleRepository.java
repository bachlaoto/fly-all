package com.ifisolution.flyrest.repositories;

import com.ifisolution.flyrest.domain.FlightSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightScheduleRepository extends JpaRepository<FlightSchedule, Long> {
}
