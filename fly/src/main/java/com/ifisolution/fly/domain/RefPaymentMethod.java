package com.ifisolution.fly.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "airlines")
public class RefPaymentMethod {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "payment_method_description")
    private String paymentMethodDescription;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "id")
    private List<Reservation> reservationList;
}
