package com.neueda.spring_container_demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    InvoiceDataInterface invoiceData() {
        return new InvoiceData();
    }

    @Bean
    InvoiceUtilitiesInterface invoiceUtilities(@Autowired InvoiceDataInterface invoiceData) {
        InvoiceUtilities invoiceUtilities = new InvoiceUtilities();
        invoiceUtilities.setInvoiceData(invoiceData);
        return invoiceUtilities;
    }
}
