package com.blueharvest.bankingapi.domain;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
/*@NamedEntityGraph(
        name = "customer.accounts.transactions",
        attributeNodes = {
                @NamedAttributeNode(value = "accounts", subgraph = "account-transactions")
        },
        subgraphs = {
                @NamedSubgraph(
                        name = "account-transactions",
                        attributeNodes = @NamedAttributeNode("transactions")
                )
        }
)*/
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_seq_gen")
    @SequenceGenerator(name = "customer_seq_gen", sequenceName = "customer_seq", allocationSize = 1)
    private int id;
    private String name;
    private String surname;

    private double balance;
    @OneToMany(cascade = CascadeType.ALL)
    Set<Account> accounts;

    public Customer() {
    }

    public Customer(int id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.accounts = new HashSet<>();
    }

    public Set<Account> getAccounts() {
        if(accounts == null){
            accounts= new HashSet<>();
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

    public void setAccounts(Set<Account> accounts) {
        this.accounts = accounts;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
