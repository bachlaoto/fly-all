package com.ifisolution.fly.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="customers")
public class Customer {
    @Column(name="id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="customer_name")
    private String customerName;
    @Column(name="other_details")
    private String otherDetails;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "id")
    private List<Reservation> reservationList;
}
