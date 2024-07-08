package ru.app.fourth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.app.fourth.dto.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
