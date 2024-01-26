package dev.Innocent.udoBank.controller;

import dev.Innocent.udoBank.entity.Transaction;
import dev.Innocent.udoBank.service.ServiceImpl.BankStatementImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/bankStatement")
@AllArgsConstructor
public class TransactionController {
    private BankStatementImpl bankStatement;
    @GetMapping
    public List<Transaction> generateBankStatement(@RequestParam String accountNumber,
                                                   @RequestParam String stateDate,
                                                   @RequestParam String endDate){
        return bankStatement.generateStatement(accountNumber, stateDate, endDate);
    }
}
