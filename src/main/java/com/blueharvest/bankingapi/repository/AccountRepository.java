package com.blueharvest.bankingapi.repository;

import com.blueharvest.bankingapi.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Integer> {
}
