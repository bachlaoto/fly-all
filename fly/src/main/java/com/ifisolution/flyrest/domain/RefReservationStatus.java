package com.ifisolution.flyrest.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="ref_reservation_status")
public class RefReservationStatus {
    @Column(name="id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="reservation_status_description")
    private String reservationStatusDescription;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "id")
    private List<Reservation> reservationList;
}
