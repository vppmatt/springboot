package com.neueda;

import jakarta.persistence.*;

import java.util.List;

public class TestHarness1 {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("invoiceManagerPersistenceUnit");
        EntityManager em = factory.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        //STEP 1 - find customers

        //Query query = em.createQuery("select c from Customer c");
        TypedQuery<Customer> getAllCustomersQuery = em.createQuery("select c from Customer c", Customer.class);
        List<Customer> customers = getAllCustomersQuery.getResultList();

        for (Customer customer : customers) {
            System.out.println(customer.toString());
        }

        Customer customer81 = em.find(Customer.class, 81L);
        System.out.println("Customer 81 is " + customer81);

        TypedQuery<Customer> getSpecificCustomerQuery =
                em.createQuery("select c from Customer c where c.phone like '+33%'", Customer.class);
        Customer foundCustomer = getSpecificCustomerQuery.getSingleResult();
        System.out.println("Customer " + foundCustomer );


        //STEP 2 - create a customer
        tx.begin();
        Customer newCustomer = new Customer("Fast Trains Ltd","10 Any Road","Any Town", null, "AB1 2CD", "UK", "someemail@notvalid.com", "+44 123456789");
        em.persist(newCustomer);
        tx.commit();

        System.out.println("The new customer was given an ID of " + newCustomer.getId());

        customers = getAllCustomersQuery.getResultList();

        for (Customer customer : customers) {
            System.out.println(customer.toString());
        }

        //STEP 3 - update a customer
        tx.begin();
        newCustomer.setName("Slow Trains Ltd");
        tx.commit();

        customers = getAllCustomersQuery.getResultList();

        for (Customer customer : customers) {
            System.out.println(customer.toString());
        }


        //STEP 4 - delete a customer
        tx.begin();
        em.remove(newCustomer);
        tx.commit();

       em.close();
       factory.close();

    }
}