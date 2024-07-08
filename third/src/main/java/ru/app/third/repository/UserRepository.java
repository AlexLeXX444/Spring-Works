package ru.app.third.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.app.third.dto.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAllByAge(int age);
}
