package bootcamelactivemq.queue;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public class Order {

    private UUID id;
    private String product;
    private LocalDateTime date;
    private BigDecimal value;

    public Order(){}

    public Order(UUID id, String product, LocalDateTime date, BigDecimal value) {
        this.id = id;
        this.product = product;
        this.date = date;
        this.value = value;
    }

    public UUID getId() {
        return id;
    }

    public String getProduct() {
        return product;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public BigDecimal getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", product='" + product + '\'' +
                ", date=" + date +
                ", value=" + value +
                '}';
    }
}
