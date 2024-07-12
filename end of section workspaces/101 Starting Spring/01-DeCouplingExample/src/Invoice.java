import java.util.*;

public class Invoice {

    private Integer id;

    private Integer customerId;
    private Double total;

    private List<String> items;

    public Invoice() {}

    public Invoice(Integer id, Integer customerId, Double total, List<String> items) {
        this.id = id;
        this.customerId = customerId;
        this.total = total;
        this.items = items;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public Double getTotal() {
        return total;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public List<String> getItems() {
        return items;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }

}
