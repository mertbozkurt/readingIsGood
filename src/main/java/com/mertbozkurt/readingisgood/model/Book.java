package com.mertbozkurt.readingisgood.model;

import javax.persistence.*;


@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "auther")
    private String auther;

    @Column(name = "year")
    private int year;

    @Column(name = "publisher")
    public String publisher;

    @Column(name = "price")
    public double price;
}
