package org.example.exercises.design_patterns.adapter.util;

import java.math.BigDecimal;

public class Pair {
    private String number;
    private BigDecimal price;
    public Pair(String number, BigDecimal price) {
        this.number = number;
        this.price = price;
    }

    public String getNumber() {
        return number;
    }

    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "number=" + number +
                ", price=" + price +
                '}';
    }
}
