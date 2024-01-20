package dev.Innocent.udoBank.service;

import dev.Innocent.udoBank.DTO.TransactionDTO;

public interface TransactionService {
    void saveTransaction(TransactionDTO transactionDTO);
}
