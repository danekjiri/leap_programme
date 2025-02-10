package com.tesco.jiridanek1.challenges.linkedlist;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class DistanceLinkedList {
    private final LinkedList<Location> orderedLocations;
    private final ListIterator<Location> iterator;

    public DistanceLinkedList(String start, Location... locations) {
        this.orderedLocations = new LinkedList<>();

        this.orderedLocations.add(new Location(start, 0));
        Arrays.sort(locations, new LocationComparator());
        this.orderedLocations.addAll(List.of(locations));

        this.iterator = this.orderedLocations.listIterator();
    }

    public void forward() {
        if (iterator.hasNext()) {
            Location location = iterator.next();
            System.out.println(location);
        } else {
            System.out.println("No more locations forwards");
        }
    }

    public void backward() {
        if (iterator.hasPrevious()) {
            Location location = iterator.previous();
            System.out.println(location);
        } else {
            System.out.println("No more locations backwards");
        }
    }

    public void listPlaces() {
        for (Location location : orderedLocations) {
            System.out.println(location);
        }
    }

    public void showMenu() {
        final String menu = """
                Available actions (select word or letter):
                (F)orward
                (B)ackward
                (L)ist Places
                (M)enu
                (Q)uit
                """;
        System.out.println(menu);
    }

}
