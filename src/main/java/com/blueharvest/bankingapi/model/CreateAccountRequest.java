package com.blueharvest.bankingapi.model;

public class CreateAccountRequest {
    private int customerId;
    private double initialCredit;

    public CreateAccountRequest(int customerId, double initialCredit) {
        this.customerId = customerId;
        this.initialCredit = initialCredit;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public double getInitialCredit() {
        return initialCredit;
    }

    public void setInitialCredit(double initialCredit) {
        this.initialCredit = initialCredit;
    }
}
