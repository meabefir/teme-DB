package com.example.demo.repository;

import com.example.demo.dao.OrderDAO;
import com.example.demo.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
