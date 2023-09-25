package com.blueharvest.bankingapi.dto;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private int id;
    private double balance;
    private List<Transaction> transactions;

    public Account() {
    }

    public Account(int id, double balance) {
        this.id = id;
        this.balance = balance;
        this.transactions = new ArrayList<>();
    }

    public List<Transaction> getTransactions() {
        if(transactions == null){
            transactions = new ArrayList<>();
        }
        return transactions;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}
