package com.example.temaspring4ShopifyGetsExposed.service;

import com.example.temaspring4ShopifyGetsExposed.database.Database;
import com.example.temaspring4ShopifyGetsExposed.model.Order;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.sql.SQLException;
import java.util.ArrayList;

@Service
public class OrderService {
    public Order getOrder(int id) throws SQLException {
        return Database.getOrderById((int)id);
    }

    public Order createOrder(Order order) throws SQLException {
        return Database.insertOrder(order);
    }

    public ArrayList<Order> getAllOrders() throws SQLException {
        return Database.getAllOrders();
    }

    public boolean deleteOrder(int id) throws SQLException {
        return Database.deleteOrderById(id);
    }

    public Order updateOrder(Order order) throws SQLException {
        return Database.updateOrder(order);
    }

    public ArrayList<Order> getOrdersWithCustomerId(int id) throws SQLException {
        return Database.getOrdersWithCustomerId(id);
    }
}
