package dev.InnocentUdo.repository;

import dev.InnocentUdo.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
