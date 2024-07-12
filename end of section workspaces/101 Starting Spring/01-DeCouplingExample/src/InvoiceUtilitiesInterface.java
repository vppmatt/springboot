import java.util.*;

public interface InvoiceUtilitiesInterface {

    void setInvoiceData(InvoiceDataInterface invoiceData);

    Invoice generateInvoice();

    void payInvoice(Integer invoiceId);

    List<Invoice> getInvoicesForCustomer(Integer customerId);
}
