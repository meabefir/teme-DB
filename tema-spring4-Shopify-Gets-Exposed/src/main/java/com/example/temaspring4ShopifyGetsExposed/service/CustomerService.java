package com.example.temaspring4ShopifyGetsExposed.service;

import com.example.temaspring4ShopifyGetsExposed.database.Database;
import com.example.temaspring4ShopifyGetsExposed.model.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class CustomerService {
    public Customer getCustomer(int id) throws SQLException {
        return Database.getCustomerById((int)id);
    }

    public Customer createCustomer(Customer customer) throws SQLException {
        return Database.insertCustomer(customer);
    }
}
