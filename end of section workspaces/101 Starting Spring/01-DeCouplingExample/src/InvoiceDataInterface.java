import java.util.*;

public interface InvoiceDataInterface {

    public List<Invoice> getAllInvoicesForCustomer(Integer customerId) ;
    public List<Invoice> getAllOverdueInvoices() ;
    public Invoice findInvoice(Integer invoiceId) ;
    public boolean updateInvoice(Invoice invoice) ;

}
