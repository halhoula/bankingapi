package com.blueharvest.bankingapi.transformer.impl;

import com.blueharvest.bankingapi.domain.Account;
import com.blueharvest.bankingapi.transformer.IAccountTransformer;
import org.springframework.stereotype.Component;

@Component
public class AccountTransformer implements IAccountTransformer {

    public Account toDTO(com.blueharvest.bankingapi.model.Account account) {
        Account dto = new Account();
        dto.setId(account.getId());
        dto.setBalance(account.getBalance());
        return dto;
    }

    public com.blueharvest.bankingapi.model.Account toModel(Account dto) {
        com.blueharvest.bankingapi.model.Account account = new com.blueharvest.bankingapi.model.Account();
        account.setId(dto.getId());
        account.setBalance(dto.getBalance());
        return account;
    }
}
