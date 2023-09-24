package com.bueharvest.bankingapi.repository;

import com.bueharvest.bankingapi.domain.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
}
