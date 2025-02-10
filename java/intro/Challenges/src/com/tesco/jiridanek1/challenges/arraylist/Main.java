package com.tesco.jiridanek1.challenges.arraylist;

import java.util.Scanner;

public class Main {
    public static final String helpText = """
            Available actions:
            0 - to shutdown
            1 - to add item(s) to list (comma delimited list)
            2 - to remove any items (comma delimited list)
            Enter a number for which action you would like to do:
            """;

    public static void main(String[] args) {
        var state = State.START;
        var scanner = new Scanner(System.in);
        var groceries = new Groceries();

        while (state != State.SHUTDOWN) {
            groceries.printSortedGroceries();

            boolean isInt = scanner.hasNextInt();
            if (!isInt) {
                scanner.nextLine();
                System.out.println("Please enter a number");
                continue;
            }

            int actionId = scanner.nextInt();
            state = state.execute(actionId, groceries);
        }
    }
}
