package dev.InnocentUdo.repository;

import dev.InnocentUdo.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
