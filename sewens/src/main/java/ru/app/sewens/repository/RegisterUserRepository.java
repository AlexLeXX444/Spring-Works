package ru.app.sewens.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.app.sewens.entity.RegisterUser;

import java.util.Optional;

@Repository
public interface RegisterUserRepository extends JpaRepository<RegisterUser, Long> {
    Optional<RegisterUser> findByLogin(String login);
}
