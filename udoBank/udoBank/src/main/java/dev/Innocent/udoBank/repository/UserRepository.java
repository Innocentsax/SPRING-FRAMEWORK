package dev.Innocent.udoBank.repository;

import dev.Innocent.udoBank.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
