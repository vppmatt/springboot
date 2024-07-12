package com.neueda.spring_jpa_demo;

import com.neueda.spring_jpa_demo.entities.Customer;
import com.neueda.spring_jpa_demo.entities.Invoice;
import com.neueda.spring_jpa_demo.repositories.CustomerRepository;
import com.neueda.spring_jpa_demo.repositories.InvoiceRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class SpringJpaDemoApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(SpringJpaDemoApplication.class, args);

		CustomerRepository customerRepository = context.getBean(CustomerRepository.class);

		for (Customer customer : customerRepository.findAll()) {
			System.out.println(customer.toString());
		}

		for (Customer customer : customerRepository.findAllByCountry("UK")) {
			System.out.println(customer.toString());
		}

		Customer customer81 = customerRepository.findById(81).get();
		Invoice invoice = new Invoice();
		invoice.setAmount(100.0);
		invoice.setDate(LocalDate.now());
		invoice.setCustomer(customer81);
		customer81.getInvoices().add(invoice);
		customerRepository.save(customer81);

		InvoiceRepository invoiceRepository = context.getBean(InvoiceRepository.class);
		invoiceRepository.findAll().forEach(System.out::println);

	}

}
