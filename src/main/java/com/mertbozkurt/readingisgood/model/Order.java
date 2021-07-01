package com.mertbozkurt.readingisgood.model;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "customer_Id")
    private Long customerId;

    @ElementCollection
    private List<Long> bookIds;

    @Column(name = "status")
    private String status;
}
