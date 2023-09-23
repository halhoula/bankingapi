package com.bueharvest.bankingapi.controller;

import com.bueharvest.bankingapi.exceptions.CustomerNotFoundException;
import com.bueharvest.bankingapi.model.CreateAccountRequest;
import com.bueharvest.bankingapi.model.Customer;
import com.bueharvest.bankingapi.wfw.IAccountWfw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(
        origins = "*",
        methods = {RequestMethod.GET, RequestMethod.POST},
        allowedHeaders = {"*"}
)
@RestController
public class ApiController {

    @Autowired
    private IAccountWfw accountWfw;

    @PostMapping("/createAccount")
    public String createAccount(@RequestBody CreateAccountRequest request) throws CustomerNotFoundException {
        return accountWfw.createAccount(request.getCustomerId(), request.getInitialCredit());
    }

    @GetMapping("/getUserInfo/{customerId}")
    public Customer getUserInfo(@PathVariable int customerId) throws CustomerNotFoundException {
        return accountWfw.getUserInfo(customerId);
    }

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<String> handleCustomerNotFoundException(CustomerNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

}
