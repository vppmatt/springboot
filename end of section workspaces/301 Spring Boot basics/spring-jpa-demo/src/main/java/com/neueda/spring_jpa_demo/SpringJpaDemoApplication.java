package com.neueda.spring_jpa_demo;

import com.neueda.spring_jpa_demo.entities.Customer;
import com.neueda.spring_jpa_demo.entities.Invoice;
import com.neueda.spring_jpa_demo.repositories.InvoiceRepository;
import com.neueda.spring_jpa_demo.service.CustomerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;


@SpringBootApplication
public class SpringJpaDemoApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(SpringJpaDemoApplication.class, args);

		CustomerService customerService = context.getBean(CustomerService.class);

		for (Customer customer : customerService.findAll()) {
			System.out.println(customer.toString());
		}

		for (Customer customer : customerService.findAllByCountry("UK")) {
			System.out.println(customer.toString());
		}

		Customer customer81 = customerService.findById(81);
		Invoice invoice = new Invoice();
		invoice.setAmount(100.0);
		invoice.setDate(LocalDate.now());
		invoice.setCustomer(customer81);
		customer81.getInvoices().add(invoice);
		customerService.save(customer81);

		InvoiceRepository invoiceRepository = context.getBean(InvoiceRepository.class);
		invoiceRepository.findAll().forEach(System.out::println);

	}


}

