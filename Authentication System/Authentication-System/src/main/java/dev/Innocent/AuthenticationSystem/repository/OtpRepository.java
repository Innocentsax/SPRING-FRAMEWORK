package dev.Innocent.AuthenticationSystem.repository;

import dev.Innocent.AuthenticationSystem.entity.Otp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OtpRepository extends JpaRepository<Otp, Long> {
    Otp findByEmail(String email);
}
