package dev.InnocentUdo.Jwt.Service;

import dev.InnocentUdo.Jwt.DTO.Response.AuthenticationRequest;
import dev.InnocentUdo.Jwt.DTO.Response.AuthenticationResponse;
import dev.InnocentUdo.Jwt.DTO.Response.RegisterRequest;
import dev.InnocentUdo.Jwt.Enum.Role;
import dev.InnocentUdo.Jwt.Enum.TokenType;
import dev.InnocentUdo.Jwt.Repository.TokenRepository;
import dev.InnocentUdo.Jwt.Repository.UserRepository;
import dev.InnocentUdo.Jwt.User.Token;
import dev.InnocentUdo.Jwt.User.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository repository;
    private final TokenRepository tokenRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    public AuthenticationResponse register(RegisterRequest request) {
        var xser = User.builder().firstname(request.getFirstname())
                .lastname(request.getLastname()).email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
        var savedUser = repository.save(xser);
        var jwtToken = jwtService.generateToken(xser);
        SaveUserToken(savedUser, jwtToken);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }

    private void SaveUserToken(User user, String jwtToken) {
        var token = Token.builder().user(user).token(jwtToken)
                .tokenType(TokenType.BEARER).revoked(false).expired(false).build();
        tokenRepository.save(token);
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

        var xser = repository.findByEmail(request.getEmail()).orElseThrow();
        var jwtToken = jwtService.generateToken(xser);
        SaveUserToken(xser, jwtToken );
        return AuthenticationResponse.builder().token(jwtToken).build();
    }
}
