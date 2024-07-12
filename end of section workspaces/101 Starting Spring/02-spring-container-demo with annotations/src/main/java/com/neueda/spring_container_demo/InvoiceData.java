package com.neueda.spring_container_demo;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class InvoiceData implements InvoiceDataInterface {

    /*
    All the code in this class is just dummy code to make the class compile.
    It is simulating talking to a database
     */

    public InvoiceData() {

    }

    public List<Invoice> getAllInvoicesForCustomer(Integer customerId) {
        return new ArrayList<>();
    }

    public List<Invoice> getAllOverdueInvoices() {
        return new ArrayList<>();
    }

    public Invoice findInvoice(Integer invoiceId) {
        return new Invoice(1,1,12.34, null);
    }

    public boolean updateInvoice(Invoice invoice) {
        return true;
    }

}
