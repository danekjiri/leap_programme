package com.tesco.jiridanek1.challenges.abstractclass;

public final class Backup extends ProductForSale {
    private final int numberOfWords;

    public Backup(String type, double price, String description, int numberOfWords) {
        super(type, price, description);
        this.numberOfWords = numberOfWords;
    }

    @Override
    public String toString() {
        return "Backup{" +
                "numberOfWords=" + numberOfWords +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }
}
