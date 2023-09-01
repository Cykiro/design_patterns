package org.example.exercises.design_patterns.command.menu;

import java.math.BigDecimal;

public class MenuItem {
    private String name;
    private BigDecimal price;
    private int preparationTime;
    private ItemType itemType;
    private boolean ready;


    public boolean isReady() {
        return ready;
    }

    public void setReady() {
        this.ready = true;
    }

    public MenuItem(MenuItem menuItem) {
        this.itemType = menuItem.getItemType();
        this.name = menuItem.getName();
        this.price = menuItem.getPrice();
        this.preparationTime = menuItem.getPreparationTime();
    }

    public MenuItem(ItemType itemType, String name, double price, int preparationTime) {
        this.itemType = itemType;
        this.name = name;
        this.price = BigDecimal.valueOf(price);
        this.preparationTime = preparationTime;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getPreparationTime() {
        return preparationTime;
    }

    public ItemType getItemType() {
        return itemType;
    }

}
