package com.example.temaspring4ShopifyGetsExposed.controller;

import com.example.temaspring4ShopifyGetsExposed.model.OrderDetails;
import com.example.temaspring4ShopifyGetsExposed.service.OrderDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.ArrayList;

@RestController
@RequestMapping("orderDetails")
@RequiredArgsConstructor
public class OrderDetailsController {
    private final OrderDetailsService orderDetailsService;

    @GetMapping("{id}")
    public ArrayList<OrderDetails> getOrderDetailsWithOrderId(@PathVariable int id) throws SQLException {
        return orderDetailsService.getOrderDetailsWithOrderId(id);
    }
}
