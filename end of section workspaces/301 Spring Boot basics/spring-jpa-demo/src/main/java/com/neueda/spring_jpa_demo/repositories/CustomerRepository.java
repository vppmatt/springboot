package com.neueda.spring_jpa_demo.repositories;

import com.neueda.spring_jpa_demo.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    public List<Customer> findAllByCountry(String country);
}
