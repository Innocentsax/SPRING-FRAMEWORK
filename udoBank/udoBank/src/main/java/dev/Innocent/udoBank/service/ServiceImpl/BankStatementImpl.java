package dev.Innocent.udoBank.service.ServiceImpl;

import dev.Innocent.udoBank.entity.Transaction;
import dev.Innocent.udoBank.repository.TransactionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
@AllArgsConstructor
public class BankStatementImpl {
    private TransactionRepository transactionRepository;
    private static final String FILE = "C:\\Users\\Innocent Udo\\MyStatement.pdf";
    /**
     * Retrieve list of transactions within a date range given an account number
     * Generate a pdf file of transactions
     * Send the file via email
     */
    public List<Transaction> generateStatement(String accountNumber, String startDate, String endDate){
        LocalDate start = LocalDate.parse(startDate, DateTimeFormatter.ISO_DATE);
        LocalDate end = LocalDate.parse(endDate, DateTimeFormatter.ISO_DATE);
        List<Transaction> transactionList = transactionRepository.findAll().stream().filter(transaction ->
                transaction.getAccountNumber().equals(accountNumber)).filter(transaction ->
                transaction.getCreatedAt().isEqual(start.atStartOfDay())).filter((transaction -> transaction.getCreatedAt().isEqual(end.atStartOfDay()))).toList();
        return transactionList;
    }


}
