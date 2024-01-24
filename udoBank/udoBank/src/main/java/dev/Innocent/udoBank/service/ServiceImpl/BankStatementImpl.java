package dev.Innocent.udoBank.service.ServiceImpl;

import dev.Innocent.udoBank.repository.TransactionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class BankStatementImpl {
    private TransactionRepository transactionRepository;
    /**
     * Retrieve list of transactions within a date range given an account number
     * Generate a pdf file of transactions
     * Send the file via email
     */
}
