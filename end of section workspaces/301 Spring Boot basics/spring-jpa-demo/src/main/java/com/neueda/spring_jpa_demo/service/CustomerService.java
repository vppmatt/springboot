package com.neueda.spring_jpa_demo.service;

import com.neueda.spring_jpa_demo.entities.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> findAll();
    List<Customer> findAllByCountry(String country);

    Customer findById(int id);
    Customer save(Customer customer);
}
