package dev.Innocent.AuthenticationSystem.service.impl;

import dev.Innocent.AuthenticationSystem.DTO.*;
import dev.Innocent.AuthenticationSystem.Utils.AppUtils;
import dev.Innocent.AuthenticationSystem.entity.Otp;
import dev.Innocent.AuthenticationSystem.repository.OtpRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
@Slf4j
public class OtpService {
    private final OtpRepository otpRepository;
    private final EmailService emailService;

    public Response sendOtp(OtpRequest otpRequest){
        //Generate the Otp, Send the Otp and Save the Otp
        //Check if he has an Otp
        Otp existingOtp = otpRepository.findByEmail(otpRequest.getEmail());
        if(existingOtp != null){
            otpRepository.delete(existingOtp);
        }
        String otp = AppUtils.generateOtp();
        log.info("otp: {}", otp); // This is not for production
        otpRepository.save(Otp.builder()
                        .email(otpRequest.getEmail())
                        .otp(otp)
                        .expiresAt(LocalDateTime.now().plusMinutes(2))
                .build());
        emailService.sendEmail(EmailDetails.builder()
                        .subject("DO NOT DISCLOSE")
                        .recipient(otpRequest.getEmail())
                        .messageBody("This organization has sent you an otp. this otp will expire in 2 minute " + otp)
                .build());
        return Response.builder()
                .statusCode(200)
                .responseMessage("SUCCESS")
                .build();
    }

    /**
     * ascertain that the user actually sent an otp
     * ascertain that otp wasn't expired
     * ascertain the otp is correct
     */
    public Response validationOtp(OtpValidationRequest otpValidationRequest){
        Otp otp = otpRepository.findByEmail(otpValidationRequest.getEmail());
        log.info("Email: {}", otpValidationRequest.getEmail());
        if(otp == null){
            return Response.builder()
                    .statusCode(400)
                    .responseMessage("You have not send an OTP")
                    .build();
        }

        if(!otp.getOtp().equals(otpValidationRequest.getOtp())){
            return Response.builder()
                    .statusCode(400)
                    .responseMessage("Invalid otp")
                    .build();
        }

        if(otp.getExpiresAt().isBefore(LocalDateTime.now())){
            return Response.builder()
                    .statusCode(400)
                    .responseMessage("Expired otp")
                    .build();
        }

        return Response.builder()
                .statusCode(200)
                .responseMessage("SUCCESS")
                .otpResponse(OtpResponse.builder()
                        .isOtpValid(true)
                        .build())
                .build();
    }
}
