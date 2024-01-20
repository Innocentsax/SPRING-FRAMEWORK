package dev.Innocent.udoBank.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionDTO {
    private String transactionType;
    private BigDecimal amount;
    private String accountNumber;
    private String status;
}
