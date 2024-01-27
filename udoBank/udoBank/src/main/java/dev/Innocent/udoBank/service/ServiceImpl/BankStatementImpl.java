package dev.Innocent.udoBank.service.ServiceImpl;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import dev.Innocent.udoBank.entity.Transaction;
import dev.Innocent.udoBank.repository.TransactionRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

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
//    public List<Transaction> generateStatement(String accountNumber, String startDate, String endDate){
//        LocalDate start = LocalDate.parse(startDate, DateTimeFormatter.ISO_DATE);
//        LocalDate end = LocalDate.parse(endDate, DateTimeFormatter.ISO_DATE);
//        List<Transaction> transactionList = transactionRepository.findAll().stream().filter(transaction ->
//                transaction.getAccountNumber().equals(accountNumber)).filter(transaction ->
//                transaction.getCreatedAt().isEqual(start.atStartOfDay())).filter((transaction -> transaction.getCreatedAt().isEqual(end.atStartOfDay()))).toList();
//        return transactionList;
//    }

    public List<Transaction> generateStatement(String accountNumber, String startDate, String endDate) {
        LocalDate start = LocalDate.parse(startDate, DateTimeFormatter.ISO_DATE);
        LocalDate end = LocalDate.parse(endDate, DateTimeFormatter.ISO_DATE).plusDays(1); // Include transactions on the end date

        List<Transaction> transactionList = transactionRepository.findAll().stream()
                .filter(transaction -> transaction.getAccountNumber().equals(accountNumber))
                .filter(transaction -> {
                    LocalDateTime createdAt = transaction.getCreatedAt();
                    return createdAt != null && createdAt.toLocalDate().isAfter(start.minusDays(1)) && createdAt.toLocalDate().isBefore(end);
                })
                .collect(Collectors.toList());

        return transactionList;
    }

    private void designStatement(List<Transaction> transactions) throws FileNotFoundException, DocumentException {
        Rectangle statementSize = new Rectangle(PageSize.A4);
        Document document = new Document(statementSize);
        log.info("Setting size of document");
        OutputStream outputStream = new FileOutputStream(FILE);
        PdfWriter.getInstance(document, outputStream);
        document.open();

        PdfPTable bankInfoTable = new PdfPTable(1);
        PdfPCell bankName  = new PdfPCell(new Phrase("Zenith Bank"));
        bankName.setBorder(0);
        bankName.setBackgroundColor(BaseColor.BLUE);
        bankName.setPadding(20f);

        PdfPCell bankAddress = new PdfPCell(new Phrase("7 Olayinka road, Mainland Lagos"));
        bankAddress.setBorder(0);
        bankInfoTable.addCell(bankName);
        bankInfoTable.addCell(bankAddress);
    }
}
