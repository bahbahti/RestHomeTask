package com.netcracker.model;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "customers")
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customer_id;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "area", nullable = false)
    private String area;

    @Column(name = "discount", nullable = false)
    private int discount;
}
