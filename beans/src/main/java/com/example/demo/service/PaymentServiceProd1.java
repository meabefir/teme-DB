package com.example.demo.service;

import com.example.demo.model.Order;
import com.example.demo.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentServiceProd1 {
    private final PaymentRepository paymentRepository;
//    @Value( "${my.custom.var}" )
//    private String myProp;

    public void test() {
        System.out.println("payment service prod 1");
    }

    public Order createOrder(Order order) {
        System.out.println("create order in prod service 1");
        paymentRepository.save(order);
        return order;
    }
}
