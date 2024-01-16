package dev.Innocent.udoBank.service.ServiceImpl;

import dev.Innocent.udoBank.DTO.AccountInfo;
import dev.Innocent.udoBank.DTO.BankResponse;
import dev.Innocent.udoBank.DTO.EmailDetails;
import dev.Innocent.udoBank.DTO.UserRequest;
import dev.Innocent.udoBank.entity.User;
import dev.Innocent.udoBank.repository.UserRepository;
import dev.Innocent.udoBank.service.EmailService;
import dev.Innocent.udoBank.service.UserService;
import dev.Innocent.udoBank.utils.AccountUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
@Service
public class UserServiceImpl implements UserService {
    UserRepository userRepository;
    EmailService emailService;
    @Autowired
    public UserServiceImpl(UserRepository userRepository, EmailService emailService) {
        this.userRepository = userRepository;
        this.emailService = emailService;
    }

    @Override
    public BankResponse createAccount(UserRequest userRequest) {
        /**
         * Creating an account - saving a new user into the db
         * Check if a user already have an account
         */
        if(userRepository.existsByEmail(userRequest.getEmail())){
            return BankResponse.builder()
                    .responseCode(AccountUtils.ACCOUNT_EXISTS_CODE)
                    .responseMessage(AccountUtils.ACCOUNT_EXISTS_MESSAGE)
                    .accountInfo(null)
                    .build();
        }
        User newUser = User.builder()
                .firstName(userRequest.getFirstName())
                .lastName(userRequest.getLastName())
                .otherName(userRequest.getOtherName())
                .gender(userRequest.getGender())
                .address(userRequest.getAddress())
                .stateOfOrigin(userRequest.getStateOfOrigin())
                .accountNumber(AccountUtils.generateAccountNumber())
                .accountBalance(BigDecimal.ZERO)
                .email(userRequest.getEmail())
                .phoneNumber(userRequest.getPhoneNumber())
                .alternativePhoneNumber(userRequest.getAlternativePhoneNumber())
                .status("ACTIVE")
                .build();
        User savedUser = userRepository.save(newUser);
        //Send email Alert
        EmailDetails emailDetails = EmailDetails.builder()
                .recipient(savedUser.getEmail())
                .subject("ACCOUNT CREATION")
                .messageBody("Congratulation! Your account has been successfully created.\nYour Account Details:" +
                        "\nAccount name: " + savedUser.getFirstName() + " " + savedUser.getLastName() + " " +
                        savedUser.getOtherName() + "\nAccount Number: " + savedUser.getAccountNumber())
                .build();
        emailService.sendEmailAlert(emailDetails);
        return BankResponse.builder()
                .responseCode(AccountUtils.ACCOUNT_CREATION_SUCCESS)
                .responseMessage(AccountUtils.ACCOUNT_CREATION_MESSAGE)
                .accountInfo(AccountInfo.builder()
                        .accountBalance(savedUser.getAccountBalance())
                        .accountNumber(savedUser.getAccountNumber())
                        .accountName(savedUser.getFirstName() + " " + savedUser.getLastName() + " "
                                + savedUser.getOtherName())
                        .build())
                .build();
    }
}
