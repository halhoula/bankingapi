package com.blueharvest.bankingapi.transformer.impl;

import com.blueharvest.bankingapi.domain.Account;
import com.blueharvest.bankingapi.domain.Customer;
import com.blueharvest.bankingapi.domain.Transaction;
import com.blueharvest.bankingapi.transformer.ICustomerTransformer;
import com.blueharvest.bankingapi.dto.TransactionType;
import org.springframework.stereotype.Component;

@Component
public class CustomerTransformer implements ICustomerTransformer {

    public com.blueharvest.bankingapi.dto.Customer toDTO(Customer dto) {
        com.blueharvest.bankingapi.dto.Customer customer = new com.blueharvest.bankingapi.dto.Customer();
        customer.setId(dto.getId());
        customer.setName(dto.getName());
        customer.setSurname(dto.getSurname());
        customer.setBalance(dto.getBalance());
        for(Account account : dto.getAccounts()){
            customer.getAccounts().add(transformAccount(account));
        }
        return customer;
    }

    private com.blueharvest.bankingapi.dto.Account transformAccount(Account account) {
        com.blueharvest.bankingapi.dto.Account modelAccount = new com.blueharvest.bankingapi.dto.Account();
        modelAccount.setBalance(account.getBalance());
        modelAccount.setId(account.getId());
        for(Transaction transaction : account.getTransactions()){
            modelAccount.getTransactions().add(transformTransaction(transaction));
        }
        return modelAccount;
    }

    private com.blueharvest.bankingapi.dto.Transaction transformTransaction(Transaction transaction) {
        com.blueharvest.bankingapi.dto.Transaction modelTransaction = new com.blueharvest.bankingapi.dto.Transaction();
        modelTransaction.setId(transaction.getId());
        modelTransaction.setAmount(transaction.getAmount());
        if(transaction.getType() != null) {
            modelTransaction.setType(TransactionType.valueOf(transaction.getType().name()));
        }
        return modelTransaction;
    }
}
