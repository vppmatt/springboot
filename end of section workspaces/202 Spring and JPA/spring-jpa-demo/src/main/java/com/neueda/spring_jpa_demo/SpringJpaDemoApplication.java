package com.neueda.spring_jpa_demo;

import com.neueda.spring_jpa_demo.dao.CustomerDao;
import com.neueda.spring_jpa_demo.entities.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringJpaDemoApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(SpringJpaDemoApplication.class, args);

		CustomerDao customerDao = context.getBean(CustomerDao.class);

		for (Customer customer : customerDao.findAll()) {
			System.out.println(customer.toString());
		}

	}

}
