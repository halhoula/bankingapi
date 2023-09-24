package com.blueharvest.bankingapi.wfw;

import com.blueharvest.bankingapi.exceptions.CustomerNotFoundException;
import com.blueharvest.bankingapi.model.Customer;

public interface IAccountWfw {
    public String createAccount(Integer customerId, double initialCredit) throws CustomerNotFoundException;
    public Customer getUserInfo(int customerId) throws CustomerNotFoundException;
}
