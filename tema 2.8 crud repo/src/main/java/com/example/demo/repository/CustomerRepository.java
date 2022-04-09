package com.example.demo.repository;

import com.example.demo.dao.CustomerDAO;
import com.example.demo.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerRepository extends JpaRepository <Customer, Integer> {
    List<Customer> findAllByUsernameAndCityAndCountry(String username, String city, String country);

}
