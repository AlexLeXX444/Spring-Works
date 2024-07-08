package ru.app.springapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.app.springapp.entity.Student;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findById(long id);
    Student findByName(String name);
    List<Student> findStudentByGroupName(String groupName);
    List<Student> findStudentByNameContainingIgnoreCase(String name);
}
