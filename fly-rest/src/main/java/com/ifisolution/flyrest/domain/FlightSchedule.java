package com.ifisolution.flyrest.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "flight_schedules")
@JsonIgnoreProperties({"airline", "reservations"})

public class FlightSchedule {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "arrival_time")
    private Date arrivalTime;

    @Column(name = "departure_time")
    private Date departureTime;

    @Column(name = "flight_number")
    private int flightNumber;

    @Column(name = "other_details")
    private String otherDetails;

    @Column(name = "airline_code")
    private int airlineCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "airline_code", insertable = false, updatable = false)
    private Airline airline;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "flightSchedule", insertable = false, updatable = false)
    private List<Reservation> reservations;
}
