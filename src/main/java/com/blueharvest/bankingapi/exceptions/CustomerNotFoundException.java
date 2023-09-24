package com.bueharvest.bankingapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class CustomerNotFoundException extends Exception{

    public CustomerNotFoundException(String message) {
        super(message);
    }
}
