package dev.Innocent.AuthenticationSystem.controller;

import dev.Innocent.AuthenticationSystem.DTO.OtpRequest;
import dev.Innocent.AuthenticationSystem.DTO.OtpValidationRequest;
import dev.Innocent.AuthenticationSystem.DTO.Response;
import dev.Innocent.AuthenticationSystem.service.impl.OtpService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/otp")
@AllArgsConstructor
public class OtpController {
    private final OtpService otpService;

    @PostMapping("sendOtp")
    public Response sentOtp(@RequestBody OtpRequest otpRequest){
        return otpService.sendOtp(otpRequest);
    }

    @PostMapping("validateOtp")
    public Response validateOtp(@RequestBody OtpValidationRequest otpValidationRequest){
        return otpService.validationOtp(otpValidationRequest);
    }
}
