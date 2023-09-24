package com.blueharvest.bankingapi.repository;

import com.blueharvest.bankingapi.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
   /* @EntityGraph(attributePaths = {"accounts", "accounts.transactions"})
    Optional<Customer> findById(Integer id);*/

   /* @Query("SELECT c FROM Customer c JOIN FETCH c.accounts a JOIN FETCH a.transactions WHERE c.id = :customerId")
    Optional<Customer> findCustomerWithAccountsAndTransactions(@Param("customerId") Integer customerId);*/
}
