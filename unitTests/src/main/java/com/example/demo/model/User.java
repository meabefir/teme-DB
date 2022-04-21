package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
public class User implements Comparable<User>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @OneToOne(fetch = FetchType.EAGER)
    private Cart cart;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Order> orders;
    @OneToOne(fetch = FetchType.EAGER)
    private Wishlist wishlist;

    public void addOrder(Order ord) {
        orders.add(ord);
    }

    public Integer orderCount() {
        return this.getOrders().size();
    }

    @Override
    public int compareTo(User o) {
        return this.orderCount().compareTo(o.orderCount());
    }
}
