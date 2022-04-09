package com.example.demo.controller;

import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("customers")
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping()
    List<Customer> getAllCustomers() {
        return customerService.findAll();
    }

    @PostMapping()
    void createCustomer(@RequestBody Customer customer) {
        customerService.create(customer);
    }

    @GetMapping("/viewAll")
    public ModelAndView allCustomersView() {
        List<Customer> customers = customerService.findAll();
        ModelAndView modelAndView = new ModelAndView("customersView");
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }

    @GetMapping("/viewOne/{id}")
    public ModelAndView oneCustomerView(@PathVariable Integer id) {
        List<Customer> customers = new ArrayList<>();
        Optional<Customer> customer = customerService.get(id);
        if (customer.isPresent()) customers.add(customer.get());

        ModelAndView modelAndView = new ModelAndView("customersView");
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }

    @GetMapping("/filter")
    public ModelAndView filterCustomers(@RequestParam("username") String username, @RequestParam("city") String city, @RequestParam("country") String country) {

        List<Customer> customers = customerService.findAllByUsernameAndCityAndCountry(username, city, country);

        ModelAndView modelAndView = new ModelAndView("customersView");
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }

}
