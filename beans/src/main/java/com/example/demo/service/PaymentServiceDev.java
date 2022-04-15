package com.example.demo.service;

import com.example.demo.controller.PaymentController;
import com.example.demo.model.Order;
import com.example.demo.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentServiceDev {
    private final PaymentRepository paymentRepository;

    public void test() {
        System.out.println("payment service dev");
    }

    public Order createOrder(Order order) {
        System.out.println("create order in dev service");
        paymentRepository.save(order);
        return order;
    }
}
