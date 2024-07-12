import java.util.*;

public class InvoiceUtilities {

    private InvoiceData invoiceData;

    public void setInvoiceData(InvoiceData invoiceData) {
        this.invoiceData = invoiceData;
    }

    public Invoice generateInvoice() {
        return new Invoice(1,1,12.34, null);
    }

    public void payInvoice(Integer invoiceId) {
        Invoice invoice = invoiceData.findInvoice(invoiceId);
        invoice.setTotal(0.0);
        invoiceData.updateInvoice(invoice);
        System.out.println("Invoice " + invoiceId + " has been paid");
    }

    public List<Invoice> getInvoicesForCustomer(Integer customerId) {
        return invoiceData.getAllInvoicesForCustomer(customerId);
    }
}
