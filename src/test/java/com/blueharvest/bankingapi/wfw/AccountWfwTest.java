package com.blueharvest.bankingapi.wfw;

import com.blueharvest.bankingapi.domain.Account;
import com.blueharvest.bankingapi.domain.Customer;
import com.blueharvest.bankingapi.exceptions.CustomerNotFoundException;
import com.blueharvest.bankingapi.repository.AccountRepository;
import com.blueharvest.bankingapi.repository.CustomerRepository;
import com.blueharvest.bankingapi.repository.TransactionRepository;
import com.blueharvest.bankingapi.transformer.impl.CustomerTransformer;
import com.blueharvest.bankingapi.wfw.impl.AccountWfw;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AccountWfwTest {
    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    private CustomerTransformer customerTransformer;

    @Mock
    private TransactionRepository transactionRepository;

    @InjectMocks
    private AccountWfw accountWfw;


    @Test
    public void testCreateAccount() throws CustomerNotFoundException {
        // Arrange
        int customerId = 1;
        double initialCredit = 100.0;
        Customer mockCustomer = new Customer(customerId, "name", "surname");
        Account mockAccount= new Account(1, 100.0);
        when(customerRepository.findById(customerId)).thenReturn(Optional.of(mockCustomer));
        when(customerRepository.save(any(Customer.class))).thenReturn(mockCustomer);
        when(accountRepository.save(any(Account.class))).thenReturn(mockAccount);
        // Act
        String result = accountWfw.createAccount(customerId, initialCredit);

        // Assert
        assertEquals("Account 1 created successfully for customer 1", result);
        verify(customerRepository, times(1)).save(any(Customer.class));
    }

    @Test
    public void testFindById() throws CustomerNotFoundException {
        // Arrange
        int customerId = 1;
        Customer mockCustomer = new Customer(customerId, "name", "surname");
        when(customerRepository.findById(customerId)).thenReturn(Optional.of(mockCustomer));
        accountWfw.setCustomerTransformer(customerTransformer);

        // Act
        com.blueharvest.bankingapi.dto.Customer foundCustomer = accountWfw.getUserInfo(customerId);

        // Assert
        assertEquals(1, foundCustomer.getId());
        verify(customerRepository, times(1)).findById(customerId);
    }

}
