package dev.Innocent.service.Impl;

import dev.Innocent.Config.JwtProvider;
import dev.Innocent.model.User;
import dev.Innocent.repository.UserRepository;
import dev.Innocent.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final JwtProvider jwtProvider;
    @Override
    public User getUserProfile(String jwt) {
        String email = jwtProvider.getEmailFromJwtToken(jwt);
        return userRepository.findByEmail(email);
    }
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
