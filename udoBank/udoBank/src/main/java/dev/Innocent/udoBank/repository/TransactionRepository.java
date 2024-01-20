package dev.Innocent.udoBank.repository;

import dev.Innocent.udoBank.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, String> {
}
