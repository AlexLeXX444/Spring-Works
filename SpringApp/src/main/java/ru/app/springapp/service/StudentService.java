package ru.app.springapp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.app.springapp.entity.Student;
import ru.app.springapp.repo.StudentRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    /**
     * создать студента (принимает JSON) (отладиться можно с помощью Postman)
     * @param student
     * @return
     */
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    /**
     * удалить студента
     * @param id
     * @return
     */
    public boolean deleteStudentById(long id) {
        if (studentRepository.existsById(id)) {
            studentRepository.delete(studentRepository.findById(id));
            return true;
        }
        return false;
    }

    /**
     * получить студента по ID
     * @param id
     * @return
     */
    public Student getStudentById(long id) {
        return studentRepository.findById(id);
    }

    /**
     * получить всех студентов
      * @return
     */
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    /**
     * получить список студентов, чье имя содержит подстроку studentName
     * @param name
     * @return
     */
    public List<Student> getStudentsByNameContaining(String name) {
        return studentRepository.findStudentByNameContainingIgnoreCase(name);
    }

    /**
     * получить всех студентов группы
     * @param groupName
     * @return
     */
    public List<Student> getStudentsByGroupName(String groupName) {
        return studentRepository.findStudentByGroupName(groupName);
    }

    public boolean existById(long id) {
        return studentRepository.existsById(id);
    }
}
