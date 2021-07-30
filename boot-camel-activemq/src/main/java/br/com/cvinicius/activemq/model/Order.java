package br.com.cvinicius.activemq.model;

import java.math.BigDecimal;
import java.util.UUID;

public class Order {

    private UUID id;
    private String product;
    private BigDecimal value;

    public Order(){}

    public Order(UUID id, String product, BigDecimal value) {
        this.id = id;
        this.product = product;
        this.value = value;
    }

    public UUID getId() {
        return id;
    }

    public String getProduct() {
        return product;
    }

    public BigDecimal getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", product='" + product + '\'' +
                ", value=" + value +
                '}';
    }
}
