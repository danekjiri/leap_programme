package com.tesco.jiridanek1.challenges.abstractclass;

import java.util.ArrayList;

public class Store {
    private final ArrayList<Order> orders = new ArrayList<>();

    public boolean addOrder(Order order) {
        var foundOrder = findCustomer(order);
        if (foundOrder != null) {
            return orders.add(foundOrder);
        }
        return false;
    }

    private Order findOrder(Order wantedOrder) {
        for (Order order : orders) {
            if (order.getName().equals(wantedCustomer.getName())) {
                return customer;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Store store = new Store();
        Customer bob = new Customer("Bob");
        bob.add

    }
}
