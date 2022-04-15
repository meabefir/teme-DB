package com.example.demo.controller;

import com.example.demo.model.Order;
import com.example.demo.service.PaymentServiceProd1;
import com.example.demo.service.PaymentServiceProd2;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.*;

@Profile("prod")
@RestController
@RequiredArgsConstructor
@RequestMapping("payment")
public class PaymentControllerProd {
    private final PaymentServiceProd1 paymentServiceProd1;
    private final PaymentServiceProd2 paymentServiceProd2;

    @GetMapping("test")
    public void test() {
        paymentServiceProd1.test();
    }

    @PostMapping("create")
    public Order createOrder(@RequestBody Order order) {
        if (order.getPrice() < 1000) {
            return paymentServiceProd1.createOrder(order);
        } else {
            return paymentServiceProd2.createOrder(order);
        }
    }
}
