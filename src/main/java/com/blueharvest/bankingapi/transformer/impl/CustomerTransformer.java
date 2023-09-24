package com.blueharvest.bankingapi.transformer.impl;

import com.blueharvest.bankingapi.domain.Account;
import com.blueharvest.bankingapi.domain.Customer;
import com.blueharvest.bankingapi.domain.Transaction;
import com.blueharvest.bankingapi.transformer.ICustomerTransformer;
import com.blueharvest.bankingapi.model.TransactionType;
import org.springframework.stereotype.Component;

@Component
public class CustomerTransformer implements ICustomerTransformer {

    public Customer toDTO(com.blueharvest.bankingapi.model.Customer customer) {
        Customer dto = new Customer();
        dto.setId(customer.getId());
        dto.setName(customer.getName());
        dto.setSurname(customer.getSurname());
        return dto;
    }

    public com.blueharvest.bankingapi.model.Customer toModel(Customer dto) {
        com.blueharvest.bankingapi.model.Customer customer = new com.blueharvest.bankingapi.model.Customer();
        customer.setId(dto.getId());
        customer.setName(dto.getName());
        customer.setSurname(dto.getSurname());
        customer.setBalance(dto.getBalance());
        for(Account account : dto.getAccounts()){
            customer.getAccounts().add(transformAccount(account));
        }
        return customer;
    }

    private com.blueharvest.bankingapi.model.Account transformAccount(Account account) {
        com.blueharvest.bankingapi.model.Account modelAccount = new com.blueharvest.bankingapi.model.Account();
        modelAccount.setBalance(account.getBalance());
        modelAccount.setId(account.getId());
        for(Transaction transaction : account.getTransactions()){
            modelAccount.getTransactions().add(transformTransaction(transaction));
        }
        return modelAccount;
    }

    private com.blueharvest.bankingapi.model.Transaction transformTransaction(Transaction transaction) {
        com.blueharvest.bankingapi.model.Transaction modelTransaction = new com.blueharvest.bankingapi.model.Transaction();
        modelTransaction.setId(transaction.getId());
        if(transaction.getType() != null) {
            modelTransaction.setType(TransactionType.valueOf(transaction.getType().name()));
        }
        return modelTransaction;
    }
}
