package com.example.demo.repository;

import com.example.demo.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> getAllByUser_Id(Integer userId);
    List<Order> findAllByUser_IdOrderByDateDesc(Integer userId);
}
