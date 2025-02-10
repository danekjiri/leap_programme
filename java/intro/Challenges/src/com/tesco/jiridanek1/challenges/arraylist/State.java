package com.tesco.jiridanek1.challenges.arraylist;

import java.util.Scanner;

public enum State {
    START,
    SHUTDOWN,
    ADD,
    REMOVE;

    public State execute(int actionId, Groceries groceries) {
        var scanner = new Scanner(System.in);

        switch (actionId) {
            case 0 -> {
                System.out.println("shutting down...");
                return SHUTDOWN;
            }
            case 1 -> {
                String[] items = scanner.nextLine().split(",");
                groceries.addGroceries(items);
                return ADD;
            }
            case 2 -> {
                String[] items = scanner.nextLine().split(",");
                groceries.removeGroceries(items);
                return REMOVE;
            }
            default -> throw new IllegalStateException("Unexpected value: " + actionId);
        }
    }
}
