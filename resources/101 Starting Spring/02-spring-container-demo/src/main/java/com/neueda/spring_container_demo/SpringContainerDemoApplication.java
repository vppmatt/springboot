package com.neueda.spring_container_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringContainerDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringContainerDemoApplication.class, args);

		InvoiceDataInterface invoiceData = new InvoiceData();
		InvoiceUtilitiesInterface invoiceUtilities = new InvoiceUtilities();
		invoiceUtilities.setInvoiceData(invoiceData);

		Invoice invoice = invoiceUtilities.generateInvoice();
		invoiceUtilities.payInvoice(invoice.getId());


	}

}
