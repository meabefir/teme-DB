package com.example.demo.repository;

import com.example.demo.dao.CustomerDAO;
import com.example.demo.model.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository <Customer, Integer>{
//    List<Customer> findAllByUsernameAndCityAndCountry(String username, String city, String country);
}
