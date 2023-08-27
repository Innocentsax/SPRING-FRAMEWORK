package dev.InnocentUdo.Authentication_and_Authorization.Repository;

import dev.InnocentUdo.Authentication_and_Authorization.Entities.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, Integer> {
    Optional<UserInfo> findByName(String name);
}
