package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private Double price;
    private Integer quantity;

    @ManyToOne(fetch = FetchType.EAGER)
    private Cart cart;
    @ManyToOne(fetch = FetchType.EAGER)
    private Wishlist wishlist;
    @ManyToOne(fetch = FetchType.EAGER)
    private Order order;
}
