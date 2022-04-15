package com.example.demo.controller;

import com.example.demo.model.Order;
import com.example.demo.service.PaymentServiceDev;
import com.example.demo.service.PaymentServiceProd1;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.*;

@Profile("!prod")
@RestController
@RequiredArgsConstructor
@RequestMapping("payment")
public class PaymentController {

    private final PaymentServiceDev paymentServiceDev;

    @GetMapping("test")
    public void test() {
        paymentServiceDev.test();
    }

    @PostMapping("create")
    public Order createOrder(@RequestBody Order order) {
        return paymentServiceDev.createOrder(order);
    }
}
