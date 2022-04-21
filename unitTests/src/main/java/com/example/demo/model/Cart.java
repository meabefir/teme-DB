package com.example.demo.model;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Cart implements Comparable<Cart> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(fetch = FetchType.EAGER)
    private User user;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Product> products;

    public void addProduct(Product p) {
        products.add(p);
    }

    public Double totalPrice() {
        return products.stream().map(p -> p.getPrice()).reduce(0.0, (a, b) -> a + b);
    }

    @Override
    public int compareTo(Cart o) {
        return this.totalPrice().compareTo(o.totalPrice());
    }
}
