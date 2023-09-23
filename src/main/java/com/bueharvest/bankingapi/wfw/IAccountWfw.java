package com.bueharvest.bankingapi.wfw;

import com.bueharvest.bankingapi.exceptions.CustomerNotFoundException;
import com.bueharvest.bankingapi.model.Account;
import com.bueharvest.bankingapi.model.Customer;

public interface IAccountWfw {
    public String createAccount(Integer customerId, double initialCredit) throws CustomerNotFoundException;
    public Customer getUserInfo(int customerId) throws CustomerNotFoundException;
}
