package com.example.demo.repository;

import com.example.demo.dao.ProductDAO;
import com.example.demo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
