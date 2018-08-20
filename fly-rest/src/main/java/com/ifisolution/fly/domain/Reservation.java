package com.ifisolution.fly.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "reservations")
@JsonIgnoreProperties({"customer", "flightSchedule", "refClass", "refPaymentMethod", "refReservationStatus"})

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
    @Column(name = "customer_id")
    private int CustomerId;
    @Column(name = "schedule_id")
    private int ScheduleId;
    @Column(name = "class_number")
    private int ClassNumber;
    @Column(name = "payment_method_code")
    private int PaymentMethodCode;
    @Column(name = "reservation_status_code")
    private int ReservationStatusCode;

    //
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", insertable = false, updatable = false)
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "schedule_id", insertable = false, updatable = false)
    private FlightSchedule flightSchedule;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "class_number", insertable = false, updatable = false)
    private RefClass refClass;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_method_code", insertable = false, updatable = false)
    private RefPaymentMethod refPaymentMethod;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reservation_status_code", insertable = false, updatable = false)
    private RefReservationStatus refReservationStatus;

}
