package com.example.temaspring4ShopifyGetsExposed.service;

import com.example.temaspring4ShopifyGetsExposed.database.Database;
import com.example.temaspring4ShopifyGetsExposed.model.Customer;
import com.example.temaspring4ShopifyGetsExposed.model.Order;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;

@Service
public class CustomerService {
    public Customer getCustomer(int id) throws SQLException {
        return Database.getCustomerById((int)id);
    }

    public Customer createCustomer(Customer customer) throws SQLException {
        return Database.insertCustomer(customer);
    }

    public ArrayList<Customer> getAllCustomers() throws SQLException {
        return Database.getAllCustomers();
    }

    public boolean deleteCustomer(int id) throws SQLException {
        return Database.deleteCustomerById(id);
    }

    public Customer updateCustomer(Customer customer) throws SQLException {
        return Database.updateCustomer(customer);
    }

}
