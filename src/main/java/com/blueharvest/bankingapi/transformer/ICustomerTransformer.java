package com.blueharvest.bankingapi.transformer;

import com.blueharvest.bankingapi.domain.Customer;

public interface ICustomerTransformer {

    public com.blueharvest.bankingapi.dto.Customer toDTO(Customer dto);
}
