package com.neueda.spring_jpa_demo.service;

import com.neueda.spring_jpa_demo.entities.Customer;
import com.neueda.spring_jpa_demo.repositories.CustomerRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

/*
    //field injection
    @Autowired
    private CustomerRepository customerRepository;
*/

/*
    //setter injection

    private CustomerRepository customerRepository;

    @Autowired
    public void setCustomerRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

*/


    //constructor injection
    private CustomerRepository customerRepository;
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public Customer findById(int id) {
        return customerRepository.findById(id).get();
    }

    public List<Customer> findAllByCountry(String country) {
        return customerRepository.findAllByCountry(country);
    }

    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

}
