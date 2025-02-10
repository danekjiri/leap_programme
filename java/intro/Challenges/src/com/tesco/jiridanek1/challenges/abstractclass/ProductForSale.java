package com.tesco.jiridanek1.challenges.abstractclass;

public abstract class ProductForSale {
    protected final String type;
    protected final double price;
    protected final String description;


    public ProductForSale(String type, double price, String description) {
        this.type = type;
        this.price = price;
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public double getSalesPrice(int quantity) {
        return price * quantity;
    }

    public abstract String toString();
}
