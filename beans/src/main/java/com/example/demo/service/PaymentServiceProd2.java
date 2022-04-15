package com.example.demo.service;

import com.example.demo.model.Order;
import com.example.demo.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentServiceProd2 {
    private final PaymentRepository paymentRepository;

    public void test() {
        System.out.println("payment service prod 2");
    }

    public Order createOrder(Order order) {
        System.out.println("create order in prod service 2");
        order.applyDiscount();
        paymentRepository.save(order);
        return order;
    }
}
