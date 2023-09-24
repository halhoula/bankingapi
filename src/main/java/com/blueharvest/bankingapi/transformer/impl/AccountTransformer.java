package com.bueharvest.bankingapi.transformer.impl;

import com.bueharvest.bankingapi.domain.Account;
import com.bueharvest.bankingapi.transformer.IAccountTransformer;
import org.springframework.stereotype.Component;

@Component
public class AccountTransformer implements IAccountTransformer {

    public Account toDTO(com.bueharvest.bankingapi.model.Account account) {
        Account dto = new Account();
        dto.setId(account.getId());
        dto.setBalance(account.getBalance());
        return dto;
    }

    public com.bueharvest.bankingapi.model.Account toModel(Account dto) {
        com.bueharvest.bankingapi.model.Account account = new com.bueharvest.bankingapi.model.Account();
        account.setId(dto.getId());
        account.setBalance(dto.getBalance());
        return account;
    }
}
