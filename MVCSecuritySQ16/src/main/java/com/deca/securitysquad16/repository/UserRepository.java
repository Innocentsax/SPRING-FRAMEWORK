package com.deca.securitysquad16.repository;

import com.deca.securitysquad16.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
    Users findByUsername(String username);

}
