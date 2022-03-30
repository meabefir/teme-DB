package com.example.temaspring4ShopifyGetsExposed.controller;

import com.example.temaspring4ShopifyGetsExposed.database.Database;
import com.example.temaspring4ShopifyGetsExposed.model.Customer;
import com.example.temaspring4ShopifyGetsExposed.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@RequestMapping("customer")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping("{id}")
    public Customer getCustomer(@PathVariable long id) throws SQLException {
        return customerService.getCustomer((int)id);
    }

    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer) throws SQLException {
        return customerService.createCustomer(customer);
    }

}
