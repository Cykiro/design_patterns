package org.example.exercises.design_patterns.strategy.route;

import java.math.BigDecimal;

public class RouteDetails {
    private BigDecimal price;
    private Integer time;
    private Integer length;
    private String path;



    public RouteDetails() {
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getTime() {
        return time;
    }

    public double getLength() {
        return length;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
