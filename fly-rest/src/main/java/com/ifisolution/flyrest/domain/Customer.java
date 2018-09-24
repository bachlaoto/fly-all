package com.ifisolution.flyrest.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "customers")
@JsonIgnoreProperties({"reservationList"})
public class Customer {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "customer_name")
    private String customerName;
    @Column(name = "other_details")
    private String otherDetails;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "customer", insertable = false, updatable = false)
    private List<Reservation> reservationList;
}
