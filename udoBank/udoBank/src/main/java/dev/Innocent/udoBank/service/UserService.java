package dev.Innocent.udoBank.service;

import dev.Innocent.udoBank.DTO.BankResponse;
import dev.Innocent.udoBank.DTO.UserRequest;

public interface UserService {
    BankResponse createAccount(UserRequest userRequest);
}
