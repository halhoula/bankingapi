package com.bueharvest.bankingapi.repository;

import com.bueharvest.bankingapi.domain.Transaction;
import com.bueharvest.bankingapi.domain.TransactionType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class TransactionRepositoryTest {

    @Autowired
    private TransactionRepository transactionRepository;

    @Test
    public void testSaveAndFindById() {
        Transaction transaction = new Transaction();
        transaction.setAmount(100.0);
        transaction.setType(TransactionType.CREDIT);

        Transaction savedTransaction = transactionRepository.save(transaction);

        assertThat(transactionRepository.findById(transaction.getId())).isPresent().contains(savedTransaction);
    }
}
