package dev.Innocent.udoBank.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class User {
    private Long id;
    private String firstName;
    private String lastName;
    private String otherName;
    private String gender;
    private String address;
    private String stateOfOrigin;
    private String accountNumber;
    private BigDecimal accountBalance;
    private String email;
    private String phoneNumber;
    private String alternativePhoneNumber;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
}
