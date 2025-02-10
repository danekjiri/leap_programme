package com.tesco.jiridanek1.challenges.linkedlist;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var distances = new DistanceLinkedList
                ("Sydney",
                        new Location("Adelaide", 1374),
                        new Location("Alice Springs", 2771),
                        new Location("Brisbane", 917),
                        new Location("Darwin", 3972),
                        new Location("Melbourne", 877),
                        new Location("Perth", 3923));
        var scanner = new Scanner(System.in);
        Action action = Action.NONE;
        String command;

        distances.showMenu();
        while (action != Action.QUIT && scanner.hasNextLine()) {
            command = scanner.nextLine();
            command = command.toUpperCase().trim();
            switch (command) {
                case "F", "FORWARD" -> {
                    action = Action.FORWARD;
                    distances.forward();
                }
                case "B", "BACKWARD" -> {
                    action = Action.BACKWARD;
                    distances.backward();
                }
                case "L", "LIST PLACES" -> {
                    action = Action.LIST_PLACES;
                    distances.listPlaces();
                }
                case "M", "MENU" -> {
                    action = Action.MENU;
                    distances.showMenu();
                }
                case "Q", "QUIT" ->  action = Action.QUIT;
                default -> System.out.println("Invalid command");
            }
        }
    }
}
