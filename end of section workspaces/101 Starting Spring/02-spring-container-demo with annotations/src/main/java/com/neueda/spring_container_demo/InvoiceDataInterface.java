package com.neueda.spring_container_demo;

import com.neueda.spring_container_demo.Invoice;
import org.springframework.stereotype.Component;

import java.util.*;


public interface InvoiceDataInterface {

    public List<Invoice> getAllInvoicesForCustomer(Integer customerId) ;
    public List<Invoice> getAllOverdueInvoices() ;
    public Invoice findInvoice(Integer invoiceId) ;
    public boolean updateInvoice(Invoice invoice) ;

}
