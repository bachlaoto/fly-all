package com.ifisolution.fly.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "airlines")
public class Airline {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "other_details")
    private String otherDetails;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "id")
    private List<FlightSchedule> flightSchedule;
}
