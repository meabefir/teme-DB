package com.example.temaspring4ShopifyGetsExposed.controller;

import com.example.temaspring4ShopifyGetsExposed.model.Order;
import com.example.temaspring4ShopifyGetsExposed.model.OrderDetails;
import com.example.temaspring4ShopifyGetsExposed.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;

@RestController
@RequestMapping("orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @GetMapping("{id}")
    public Order getOrder(@PathVariable int id) throws SQLException {
        return orderService.getOrder(id);
    }

    @GetMapping("all")
    public ArrayList<Order> getOrders() throws SQLException {
        return orderService.getAllOrders();
    }

    @PostMapping
    public Order createOrder(@RequestBody Order order) throws SQLException {
        return orderService.createOrder(order);
    }

    @DeleteMapping("{id}")
    public boolean deleteOrder(@PathVariable int id) throws SQLException {
        return orderService.deleteOrder(id);
    }

    @PutMapping
    public Order updateOrder(@RequestBody Order order) throws SQLException {
        return orderService.updateOrder(order);
    }

    @GetMapping
    public ArrayList<Order> getOrdersWithCustomerId(@RequestParam("customer_id") int customerId) throws SQLException {
        return orderService.getOrdersWithCustomerId(customerId);
    }
}
