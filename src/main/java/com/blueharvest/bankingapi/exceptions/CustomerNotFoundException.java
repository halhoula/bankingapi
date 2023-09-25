package com.blueharvest.bankingapi.exceptions;

public class CustomerNotFoundException extends Exception{

    public CustomerNotFoundException(String message) {
        super(message);
    }
}
