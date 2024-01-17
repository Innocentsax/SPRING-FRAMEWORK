package dev.Innocent.udoBank.service;

import dev.Innocent.udoBank.DTO.BankResponse;
import dev.Innocent.udoBank.DTO.EnquiryRequest;
import dev.Innocent.udoBank.DTO.UserRequest;

public interface UserService {
    BankResponse createAccount(UserRequest userRequest);
    BankResponse balanceEnquiry(EnquiryRequest enquiryRequest);
    String nameEnquiry(EnquiryRequest enquiryRequest);
}
