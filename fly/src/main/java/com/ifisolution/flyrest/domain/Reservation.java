package com.ifisolution.flyrest.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "reservations")
public class Reservation {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "date_of_flight")
    private Date dateOfFlight;
    @Column(name = "date_reservation_made")
    private Date dateReservationMade;

    @Column(name = "e_ticker_number")
    private int eTickerNumber;

    @Column(name = "other_details")
    private String otherDetails;

//    private int customerId;

    @ManyToOne
    private Customer customer;

    @ManyToOne
    private FlightSchedule flightSchedule;

    @ManyToOne
    private RefClass refClass;

    @ManyToOne
    private RefPaymentMethod refPaymentMethod;

    @ManyToOne
    private RefReservationStatus refReservationStatus;

}
