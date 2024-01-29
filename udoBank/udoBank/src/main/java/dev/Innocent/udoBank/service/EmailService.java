package dev.Innocent.udoBank.service;

import dev.Innocent.udoBank.DTO.EmailDetails;

public interface EmailService {
    void sendEmailAlert(EmailDetails emailDetails);
    void sendEmailWithAttachment(EmailDetails emailDetails);
}
