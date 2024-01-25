package dev.Innocent.udoBank.service.ServiceImpl;

import dev.Innocent.udoBank.entity.Transaction;
import dev.Innocent.udoBank.repository.TransactionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class BankStatementImpl {
    private TransactionRepository transactionRepository;
    /**
     * Retrieve list of transactions within a date range given an account number
     * Generate a pdf file of transactions
     * Send the file via email
     */
    public List<Transaction> generateStatement(String accountNumber, String startDate, String endDate){
        List<Transaction> transactionList = transactionRepository.findAll().stream().filter(transaction ->
                transaction.getAccountNumber().equals(accountNumber)).filter(transaction -> transaction.getCreatedAt())
    }
}
