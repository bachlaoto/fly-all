package com.ifisolution.fly.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "airlines")
@JsonIgnoreProperties({"flightSchedule"})

public class Airline {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "other_details")
    private String otherDetails;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "airline", insertable = false, updatable = false)
    private List<FlightSchedule> flightSchedule;
}
