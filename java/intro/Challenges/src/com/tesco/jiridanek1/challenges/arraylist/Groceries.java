package com.tesco.jiridanek1.challenges.arraylist;

import java.util.ArrayList;
import java.util.Collections;

public class Groceries {
    private final ArrayList<String> list = new ArrayList<>();

    public void addGroceries(String... groceries) {
        for (var grocery : groceries) {
            if (!list.contains(grocery) && !grocery.isEmpty()) {
                list.add(grocery.trim());
            }
        }
    }

    public void removeGroceries(String... groceries) {
        for (var grocery : groceries) {
            list.remove(grocery.trim());
        }
    }

    public void printSortedGroceries() {
        Collections.sort(list);
        System.out.println(list);
    }
}