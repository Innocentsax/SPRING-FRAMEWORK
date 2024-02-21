package dev.Innocent.AuthenticationSystem.controller;

import dev.Innocent.AuthenticationSystem.DTO.Request;
import dev.Innocent.AuthenticationSystem.DTO.Response;
import dev.Innocent.AuthenticationSystem.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/auth")
@AllArgsConstructor
public class UserController {
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<Response> signup(@RequestBody Request request){
        return userService.signup(request);
    }
}
