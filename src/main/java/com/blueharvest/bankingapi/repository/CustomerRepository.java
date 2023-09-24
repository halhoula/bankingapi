package com.bueharvest.bankingapi.repository;

import com.bueharvest.bankingapi.domain.Customer;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
   /* @EntityGraph(attributePaths = {"accounts", "accounts.transactions"})
    Optional<Customer> findById(Integer id);*/

   /* @Query("SELECT c FROM Customer c JOIN FETCH c.accounts a JOIN FETCH a.transactions WHERE c.id = :customerId")
    Optional<Customer> findCustomerWithAccountsAndTransactions(@Param("customerId") Integer customerId);*/
}
