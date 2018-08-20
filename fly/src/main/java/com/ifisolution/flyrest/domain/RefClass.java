package com.ifisolution.flyrest.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="ref_payment_methods")
public class RefClass {
    @Column(name="id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="payment_method_description")
    private String paymentMethodDescription;

    @OneToMany(mappedBy = "id")
    private List<Reservation> reservationList;
}
