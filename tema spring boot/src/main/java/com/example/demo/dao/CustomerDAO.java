package com.example.demo.dao;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerDAO implements DAO <Customer> {
    private final CustomerRepository customerRepository;

    @Override
    public Optional<Customer> get(Integer id) {
        return customerRepository.findById(id);
    }

    public List<Customer> findAllByUsernameAndCityAndCountry(String username, String city, String country) {
        return customerRepository.findAllByUsernameAndCityAndCountry(username, city, country);
    }

    public List<Customer> findAll() {
        List<Customer> ret = new ArrayList<>();
        customerRepository.findAll().forEach(ret::add);
        System.out.println(ret);
        return ret;
    }

    @Override
    public void create(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void delete(Customer customer) {
        customerRepository.delete(customer);
    }

    @Override
    public void update(Customer customer) {
        customerRepository.save(customer);
    }
}
