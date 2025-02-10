package com.tesco.jiridanek1.challenges.abstractclass;

import java.util.ArrayList;

public class Order {
    private final ArrayList<OrderItem> orderItems;

    public Order() {
        orderItems = new ArrayList<>();
    }

    public boolean addOrderItem(OrderItem orderItem) {
        var foundOrderItem = getOrderItemByType(orderItem.getProductForSale().getType());
        if (foundOrderItem == null) {
            return orderItems.add(orderItem);
        }
        return false;
    }

    public void printOrder() {
        System.out.println("Order items:");

        for (var orderItem : orderItems) {
            System.out.println(orderItem.getQuantity() + "x " + orderItem.getProductForSale().getType());
        }
    }

    private OrderItem getOrderItemByType(String type) {
        for (var item : orderItems) {
            var productForSaleType = item.getProductForSale().getType();
            if (productForSaleType.equals(type)) {
                return item;
            }
        }
        return null;
    }
}
