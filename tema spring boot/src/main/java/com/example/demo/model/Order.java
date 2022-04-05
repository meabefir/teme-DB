package com.example.demo.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "myorder")
public class Order {
    @Id
    @GeneratedValue
    private Integer id;
    private Long timestamp;
}
