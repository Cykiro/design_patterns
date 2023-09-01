package org.example.exercises.design_patterns.singleton.model;

import java.math.BigDecimal;


public class Client {
    private String userId;
    private String password;
    private BigDecimal money;

    public Client() {
    }


    public Client(String userId, String password) {
        this.userId = userId;
        this.password = password;
        this.money = new BigDecimal(0);
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }
}
