package com.blueharvest.bankingapi.repository;

import com.blueharvest.bankingapi.domain.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
}
