package com.example.demo.dao;

import com.example.demo.model.Order;
import com.example.demo.repository.OrderRepository;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class OrderDAO implements DAO <Order> {
    private final OrderRepository orderRepository;

    @Override
    public Optional<Order> get(Integer id) {
        return orderRepository.findById(id);
    }

    @Override
    public void create(Order order) {
        orderRepository.save(order);
    }

    @Override
    public void delete(Order order) {
        orderRepository.delete(order);
    }

    @Override
    public void update(Order order) {
        orderRepository.save(order);
    }
}
