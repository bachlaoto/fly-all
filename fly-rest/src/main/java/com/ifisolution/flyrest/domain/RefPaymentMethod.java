package com.ifisolution.flyrest.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "ref_payment_methods")
@JsonIgnoreProperties({"reservationList"})

public class RefPaymentMethod {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "payment_method_description")
    private String paymentMethodDescription;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "refPaymentMethod", insertable = false, updatable = false)
    private List<Reservation> reservationList;
}
