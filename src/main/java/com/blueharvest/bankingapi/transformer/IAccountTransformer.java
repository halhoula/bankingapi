package com.bueharvest.bankingapi.transformer;

import com.bueharvest.bankingapi.domain.Account;

public interface IAccountTransformer {
    public Account toDTO(com.bueharvest.bankingapi.model.Account account);
    public com.bueharvest.bankingapi.model.Account toModel(Account dto);
}
