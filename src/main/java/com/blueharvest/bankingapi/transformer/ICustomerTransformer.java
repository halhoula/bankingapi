package com.blueharvest.bankingapi.transformer;

import com.blueharvest.bankingapi.domain.Customer;

public interface ICustomerTransformer {

    public Customer toDTO(com.blueharvest.bankingapi.model.Customer customer);

    public com.blueharvest.bankingapi.model.Customer toModel(Customer dto);
}
