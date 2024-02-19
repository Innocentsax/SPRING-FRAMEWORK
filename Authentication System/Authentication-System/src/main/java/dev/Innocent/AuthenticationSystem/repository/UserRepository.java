package dev.Innocent.AuthenticationSystem.repository;

import dev.Innocent.AuthenticationSystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

}
