package com.ifisolution.flyrest.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "flight_schedules")
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

    @ManyToOne
    private Customer customer;

    @OneToMany(mappedBy = "id")
    private List<Reservation> reservations;
}
