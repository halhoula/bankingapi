package com.blueharvest.bankingapi.repository;

import com.blueharvest.bankingapi.domain.Account;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class AccountRepositoryTest {

    @Autowired
    private AccountRepository accountRepository;

    @Test
    public void testSaveAndFindById() {
        Account account = new Account();
        account.setBalance(1000.0);

        Account savecAccount = accountRepository.save(account);

        Assertions.assertThat(accountRepository.findById(account.getId())).isPresent().contains(savecAccount);
    }
}
