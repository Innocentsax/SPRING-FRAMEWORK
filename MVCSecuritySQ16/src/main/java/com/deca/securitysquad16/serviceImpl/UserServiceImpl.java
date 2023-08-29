package com.deca.securitysquad16.serviceImpl;

import com.deca.securitysquad16.enums.Role;
import com.deca.securitysquad16.models.Users;
import com.deca.securitysquad16.repository.UserRepository;
import com.deca.securitysquad16.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        userRepository.save(Users.builder().username(username)
//                .password(new BCryptPasswordEncoder().encode(username.split("@")[0]))
//                .role(Role.USER)
//                .build());
        return userRepository.findByUsername(username);
    }
}
