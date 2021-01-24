package org.softdevelop.demo.banking.repository;

import org.softdevelop.demo.banking.model.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BankRepository extends JpaRepository<Bank, Integer> {
    Optional<Bank> findByName(String name);
}
