package com.bueharvest.bankingapi.transformer;

import com.bueharvest.bankingapi.domain.Customer;

public interface ICustomerTransformer {

    public Customer toDTO(com.bueharvest.bankingapi.model.Customer customer);

    public com.bueharvest.bankingapi.model.Customer toModel(Customer dto);
}
