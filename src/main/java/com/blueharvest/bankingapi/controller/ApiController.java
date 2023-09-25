package com.blueharvest.bankingapi.controller;

import com.blueharvest.bankingapi.dto.CreateAccountRequest;
import com.blueharvest.bankingapi.exceptions.CustomerNotFoundException;
import com.blueharvest.bankingapi.dto.Customer;
import com.blueharvest.bankingapi.wfw.IAccountWfw;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static final Logger log = LoggerFactory.getLogger(ApiController.class);

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
        log.error("An error occurred: ", ex);
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

}
