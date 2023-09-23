package com.bueharvest.bankingapi.transformer.impl;

import com.bueharvest.bankingapi.domain.Account;
import com.bueharvest.bankingapi.domain.Customer;
import com.bueharvest.bankingapi.domain.Transaction;
import com.bueharvest.bankingapi.model.TransactionType;
import com.bueharvest.bankingapi.transformer.ICustomerTransformer;
import org.springframework.stereotype.Component;

@Component
public class CustomerTransformer implements ICustomerTransformer {

    public Customer toDTO(com.bueharvest.bankingapi.model.Customer customer) {
        Customer dto = new Customer();
        dto.setId(customer.getId());
        dto.setName(customer.getName());
        dto.setSurname(customer.getSurname());
        return dto;
    }

    public com.bueharvest.bankingapi.model.Customer toModel(Customer dto) {
        com.bueharvest.bankingapi.model.Customer customer = new com.bueharvest.bankingapi.model.Customer();
        customer.setId(dto.getId());
        customer.setName(dto.getName());
        customer.setSurname(dto.getSurname());
        customer.setBalance(dto.getBalance());
        for(Account account : dto.getAccounts()){
            customer.getAccounts().add(transformAccount(account));
        }
        return customer;
    }

    private com.bueharvest.bankingapi.model.Account transformAccount(Account account) {
        com.bueharvest.bankingapi.model.Account modelAccount = new com.bueharvest.bankingapi.model.Account();
        modelAccount.setBalance(account.getBalance());
        modelAccount.setId(account.getId());
        for(Transaction transaction : account.getTransactions()){
            modelAccount.getTransactions().add(transformTransaction(transaction));
        }
        return modelAccount;
    }

    private com.bueharvest.bankingapi.model.Transaction transformTransaction(Transaction transaction) {
        com.bueharvest.bankingapi.model.Transaction modelTransaction = new com.bueharvest.bankingapi.model.Transaction();
        modelTransaction.setId(transaction.getId());
        if(transaction.getType() != null) {
            modelTransaction.setType(TransactionType.valueOf(transaction.getType().name()));
        }
        return modelTransaction;
    }
}
