package com.neueda.spring_jpa_demo.dao;

import com.neueda.spring_jpa_demo.entities.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerDao {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Customer> findAll() {
        TypedQuery<Customer> getAllCustomersQuery = entityManager.createQuery("select c from Customer c", Customer.class);
        return getAllCustomersQuery.getResultList();
    }
}
