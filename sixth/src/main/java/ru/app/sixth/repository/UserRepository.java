package ru.app.sixth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.app.sixth.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
