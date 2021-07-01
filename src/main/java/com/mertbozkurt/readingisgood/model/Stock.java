package com.mertbozkurt.readingisgood.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "stock")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    @Column(name = "book_Id")
    private long bookId;

    @Column(name = "stock")
    private int stock;
}
