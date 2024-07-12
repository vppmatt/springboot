package com.neueda.spring_container_demo;

import java.util.*;

public interface InvoiceUtilitiesInterface {

    void setInvoiceData(InvoiceDataInterface invoiceData);

    Invoice generateInvoice();

    void payInvoice(Integer invoiceId);

    List<Invoice> getInvoicesForCustomer(Integer customerId);
}
