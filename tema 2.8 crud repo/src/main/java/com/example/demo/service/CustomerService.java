package com.example.demo.service;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    public List<Customer> findAllByUsernameAndCityAndCountry(String username, String city, String country) {
        return customerRepository.findAllByUsernameAndCityAndCountry(username, city, country);
    }

    public List<Customer> findAll() {
        List<Customer> ret = new ArrayList<>();
        customerRepository.findAll().forEach(ret::add);
        System.out.println(ret);
        return ret;
    }

    public Optional<Customer> get(Integer id) {
        return customerRepository.findById(id);
    }

    public void create(Customer customer) {
        customerRepository.save(customer);
    }

    public void delete(Customer customer) {
        customerRepository.delete(customer);
    }

    public void update(Customer customer) {
        customerRepository.save(customer);
    }
}
