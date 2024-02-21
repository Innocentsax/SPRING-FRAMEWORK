package dev.Innocent.AuthenticationSystem.service;

import dev.Innocent.AuthenticationSystem.DTO.LoginRequest;
import dev.Innocent.AuthenticationSystem.DTO.Request;
import dev.Innocent.AuthenticationSystem.DTO.Response;
import org.springframework.http.ResponseEntity;

public interface UserService {
    ResponseEntity<Response> signup(Request request);
    ResponseEntity<Response> login(LoginRequest request);
    Response resetPassword();
    Response changePassword();
}
