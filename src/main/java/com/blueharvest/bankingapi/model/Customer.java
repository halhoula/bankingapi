package com.bueharvest.bankingapi.model;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private int id;
    private String name;
    private String surname;
    private double balance;
    private List<Account> accounts;

    public Customer() {
    }

    public Customer(int id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.accounts = new ArrayList<>();
    }

    public List<Account> getAccounts() {
        if(accounts == null){
            accounts= new ArrayList<>();
        }
        return accounts;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
