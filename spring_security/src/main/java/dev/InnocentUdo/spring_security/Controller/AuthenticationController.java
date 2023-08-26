package dev.InnocentUdo.spring_security.Controller;

import dev.InnocentUdo.spring_security.DTO.LoginResponseDTO;
import dev.InnocentUdo.spring_security.DTO.RegistrationDTO;
import dev.InnocentUdo.spring_security.Model.ApplicationUser;
import dev.InnocentUdo.spring_security.Services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/register")
    public ApplicationUser registerUser(@RequestBody RegistrationDTO body){
        return authenticationService.registerUser(body.getUsername(), body.getPassword());
    }

    @PostMapping("/login")
    public LoginResponseDTO loginUser(@RequestBody RegistrationDTO body){
        return authenticationService.loginUser(body.getUsername(), body.getPassword());
    }
}
