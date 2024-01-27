package dev.Innocent.udoBank.service.ServiceImpl;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Rectangle;
import dev.Innocent.udoBank.entity.Transaction;
import dev.Innocent.udoBank.repository.TransactionRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
@AllArgsConstructor
@Slf4j
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

    private void designStatement(List<Transaction> transactions) throws FileNotFoundException {
        Rectangle statementSize = new Rectangle(PageSize.A4);
        Document document = new Document(statementSize);
        log.info("Setting size of document");
        OutputStream outputStream = new FileOutputStream(FILE);

    }
}
