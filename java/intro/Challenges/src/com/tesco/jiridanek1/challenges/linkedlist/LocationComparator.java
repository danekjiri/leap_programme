package com.tesco.jiridanek1.challenges.linkedlist;

import java.util.Comparator;

public class LocationComparator implements Comparator<Location> {
    @Override
    public int compare(Location left, Location right) {
        return left.distanceFromStart() - right.distanceFromStart();
    }
}
