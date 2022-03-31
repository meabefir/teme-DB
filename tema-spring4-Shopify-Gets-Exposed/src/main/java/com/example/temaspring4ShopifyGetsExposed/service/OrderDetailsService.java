package com.example.temaspring4ShopifyGetsExposed.service;

import com.example.temaspring4ShopifyGetsExposed.database.Database;
import com.example.temaspring4ShopifyGetsExposed.model.OrderDetails;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;

@Service
public class OrderDetailsService {
    public ArrayList<OrderDetails> getOrderDetailsWithOrderId(int id) throws SQLException {
        return Database.getOrderDetailsWithOrderId(id);
    }
}
