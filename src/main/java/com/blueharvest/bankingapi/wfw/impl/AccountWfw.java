package com.blueharvest.bankingapi.wfw.impl;

import com.blueharvest.bankingapi.domain.Account;
import com.blueharvest.bankingapi.domain.Customer;
import com.blueharvest.bankingapi.domain.Transaction;
import com.blueharvest.bankingapi.domain.TransactionType;
import com.blueharvest.bankingapi.exceptions.CustomerNotFoundException;
import com.blueharvest.bankingapi.repository.AccountRepository;
import com.blueharvest.bankingapi.repository.CustomerRepository;
import com.blueharvest.bankingapi.repository.TransactionRepository;
import com.blueharvest.bankingapi.transformer.IAccountTransformer;
import com.blueharvest.bankingapi.transformer.ICustomerTransformer;
import com.blueharvest.bankingapi.wfw.IAccountWfw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class AccountWfw implements IAccountWfw {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ICustomerTransformer customerTransformer;

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private IAccountTransformer accountTransformer;

    @Autowired
    private TransactionRepository transactionRepository;


    public String createAccount(Integer customerId, double initialCredit) throws CustomerNotFoundException {

        Customer customer = customerRepository.findById(customerId).orElse(new Customer());
        if(customer.getId() == 0){
            throw new CustomerNotFoundException("Customer "+ customerId + " not found");
        }

        // Create and save account
        Account account = new Account();
        account.setBalance(initialCredit);
        account.setCustomer(customer);
        Account newAccount = accountRepository.save(account);
        if (initialCredit != 0) {
            Transaction transaction = new Transaction();
            transaction.setAmount(initialCredit);
            transaction.setType(TransactionType.CREDIT);
            transaction.setAccount(newAccount);
            Transaction newTransaction = transactionRepository.save(transaction);
            account.getTransactions().add(newTransaction);
            newAccount = accountRepository.save(account);
        }

        // Associate account with customer and save
        customer.getAccounts().add(newAccount);
        customer.setBalance(calculerCustomerBalance(customer.getAccounts()));
        Customer newCustomer = customerRepository.save(customer);
        return "Account "+newAccount.getId()+" created successfully for customer "+newCustomer.getId();
    }

    public com.blueharvest.bankingapi.model.Customer getUserInfo(int customerId) throws CustomerNotFoundException {
        Customer customer = customerRepository.findById(customerId).orElse(new Customer());
        if(customer.getId() == 0){
            throw new CustomerNotFoundException("Customer "+ customerId + " not found");
        }
        //System.out.println("transaction ==> "+ customer.getAccounts().get(0).getTransactions().size());
        return customerTransformer.toModel(customer);
    }

    private double calculerCustomerBalance(Set<Account> accounts){
        return accounts.stream().mapToDouble(Account::getBalance).sum();
    }

    public void setCustomerTransformer(ICustomerTransformer customerTransformer) {
        this.customerTransformer = customerTransformer;
    }
}
