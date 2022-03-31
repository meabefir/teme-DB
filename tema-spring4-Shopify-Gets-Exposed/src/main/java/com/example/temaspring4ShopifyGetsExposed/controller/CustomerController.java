package com.example.temaspring4ShopifyGetsExposed.controller;

import com.example.temaspring4ShopifyGetsExposed.database.Database;
import com.example.temaspring4ShopifyGetsExposed.model.Customer;
import com.example.temaspring4ShopifyGetsExposed.model.Order;
import com.example.temaspring4ShopifyGetsExposed.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;

@RestController
@RequestMapping("customer")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping("{id}")
    public Customer getCustomer(@PathVariable int id) throws SQLException {
        return customerService.getCustomer(id);
    }

    @GetMapping("all")
    public ArrayList<Customer> getCustomers() throws SQLException {
        return customerService.getAllCustomers();
    }

    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer) throws SQLException {
        return customerService.createCustomer(customer);
    }

    @DeleteMapping("{id}")
    public boolean deleteCustomer(@PathVariable int id) throws SQLException {
        return customerService.deleteCustomer(id);
    }

    @PutMapping
    public Customer updateCustomer(@RequestBody Customer customer) throws SQLException {
        return customerService.updateCustomer(customer);
    }
}
