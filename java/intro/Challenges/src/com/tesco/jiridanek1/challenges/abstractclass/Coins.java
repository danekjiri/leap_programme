package com.tesco.jiridanek1.challenges.abstractclass;

public final class Coins extends ProductForSale{
    private double priceUSD;

    public Coins(String type, double price, String description, double priceUSD) {
        super(type, price, description);
        this.priceUSD = priceUSD;
    }

    public double getPriceUSD() {
        return priceUSD;
    }

    public void setPriceUSD(double priceUSD) {
        this.priceUSD = (priceUSD <= 0) ? 0 : priceUSD;
    }

    @Override
    public String toString() {
        return "Coins{" +
                "priceUSD=" + priceUSD +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }
}
