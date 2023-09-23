package com.bueharvest.bankingapi.repository;

import com.bueharvest.bankingapi.domain.Account;
import com.bueharvest.bankingapi.domain.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void testSaveAndFindById() {
        Customer customer = new Customer();
        customer.setName("name");
        customer.setSurname("surname");

        Customer savdCustomer = customerRepository.save(customer);

        assertThat(customerRepository.findById(customer.getId())).isPresent().contains(savdCustomer);
    }
}
