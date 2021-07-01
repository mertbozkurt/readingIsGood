package com.mertbozkurt.readingisgood.model;

import javax.persistence.*;


@Entity
@Table(name = "stock")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    @Column(name = "book_Id")
    private long bookId;

    @Column(name = "count")
    private long count;
}
