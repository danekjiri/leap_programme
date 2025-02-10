package com.tesco.jiridanek1.challenges.autoboxing;

import java.util.ArrayList;

public class Bank {
    private String bankName;
    private ArrayList<Customer> customers;

    public boolean addCustomer(Customer customer) {
        var newCustomer = findCustomer(customer.getName());
        if (newCustomer == null) {
            return customers.add(customer);
        }

        return false;
    }

    public boolean addCustomer(String customerName) {
        var newCustomer = findCustomer(customerName);
        if (newCustomer == null) {
            return customers.add(new Customer(customerName));
        }

        return false;
    }

    public boolean addCustomersTransaction(Customer customer, double transaction) {
        var foundCustomer = findCustomer(customer.getName());
        if (foundCustomer == null) {
            return false;
        }

        var transactions = foundCustomer.getTransactions();
        return transactions.add(transaction);
    }

    private Customer findCustomer(String name) {
        for (Customer customer : customers) {
            if (customer.getName().equals(name)) {
                return customer;
            }
        }
        return null;
    }

    public void printStatements(String customerName) {
        var customer = findCustomer(customerName);
        if (customer == null) {
            return;
        }

        printStatements(customer);
    }

    public void printStatements(Customer customer) {
        System.out.println(customer.getName() + ":");
        for (double transaction : customer.getTransactions()) {
            if (transaction < 0) {
                System.out.println("DEBIT TRANSACTION OF AMOUNT: " + transaction);
            } else {
                System.out.println("CREDIT TRANSACTION OF AMOUNT: " + transaction);
            }
        }
    }
}