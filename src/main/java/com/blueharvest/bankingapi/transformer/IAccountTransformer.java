package com.blueharvest.bankingapi.transformer;

import com.blueharvest.bankingapi.domain.Account;

public interface IAccountTransformer {
    public Account toDTO(com.blueharvest.bankingapi.model.Account account);
    public com.blueharvest.bankingapi.model.Account toModel(Account dto);
}
