package ru.app.fourth.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.app.fourth.dto.Student;
import ru.app.fourth.repository.StudentRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> getAll() {
        return studentRepository.findAll();
    }
}
