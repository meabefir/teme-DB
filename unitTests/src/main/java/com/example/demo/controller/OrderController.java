package com.example.demo.controller;

import com.example.demo.model.Order;
import com.example.demo.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("order")
public class OrderController {
    private final OrderService orderService;

    @PostMapping("{userId}")
    public void placeOrder(@PathVariable Integer userId) {
        orderService.placeOrder(userId);
    }

    @GetMapping("history/{userId}")
    public List<Order> orderHistory(@PathVariable Integer userId) {
        return orderService.orderHistory(userId);
    }
}
