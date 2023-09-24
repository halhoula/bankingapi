package com.bueharvest.bankingapi.repository;

import com.bueharvest.bankingapi.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Integer> {
}
