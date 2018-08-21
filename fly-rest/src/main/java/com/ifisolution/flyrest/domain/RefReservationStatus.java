package com.ifisolution.flyrest.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "ref_reservation_status")
@JsonIgnoreProperties({"reservationList"})

public class RefReservationStatus {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "reservation_status_description")
    private String reservationStatusDescription;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "refReservationStatus", insertable = false, updatable = false)
    private List<Reservation> reservationList;
}
