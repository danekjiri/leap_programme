package com.tesco.jiridanek1.challenges.abstractclass;

public final class TrezorWallet extends ProductForSale {

    public TrezorWallet(String type, double price, String description) {
        super(type, price, description);
    }

    @Override
    public String toString() {
        return "TrezorWallet{" +
                "type='" + type + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }
}
