package com.bueharvest.bankingapi.repository;

import com.bueharvest.bankingapi.domain.Account;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class AccountRepositoryTest {

    @Autowired
    private AccountRepository accountRepository;

    @Test
    public void testSaveAndFindById() {
        Account account = new Account();
        account.setBalance(1000.0);

        Account savecAccount = accountRepository.save(account);

        assertThat(accountRepository.findById(account.getId())).isPresent().contains(savecAccount);
    }
}
