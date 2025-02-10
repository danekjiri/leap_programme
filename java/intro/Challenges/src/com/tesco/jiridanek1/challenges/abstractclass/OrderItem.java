package com.tesco.jiridanek1.challenges.abstractclass;

public class OrderItem {
    private double quantity;
    private final ProductForSale productForSale;

    public OrderItem(double quantity, ProductForSale productForSale) {
        this.quantity = quantity;
        this.productForSale = productForSale;
    }

    public double getQuantity() {
        return quantity;
    }

    public ProductForSale getProductForSale() {
        return productForSale;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
}
