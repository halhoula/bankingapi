package com.blueharvest.bankingapi.repository;

import com.blueharvest.bankingapi.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
