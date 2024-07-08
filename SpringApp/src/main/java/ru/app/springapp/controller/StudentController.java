package ru.app.springapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.app.springapp.entity.Student;
import ru.app.springapp.service.StudentService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class StudentController {
    private final StudentService studentService;

    /**
     * получить студента по ID
     * @param id
     * @return
     */
    @GetMapping(value = "/student/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Student getUserById(@PathVariable long id) {
        return studentService.getStudentById(id);
    }

    /**
     * получить всех студентов
     * @return
     */
    @GetMapping(value = "/student", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    /**
     * получить список студентов, чье имя содержит подстроку поиска
     * @param name
     * @return
     */
    @GetMapping(value = "/student/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Student> searchStudentsByName(@RequestParam String name) {
        return studentService.getStudentsByNameContaining(name);
    }

    /**
     * получить всех студентов группы
     * @param groupName
     * @return
     */
    @GetMapping(value = "/group/{groupName}/student", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Student> getStudentsByGroup(@PathVariable String groupName) {
        return studentService.getStudentsByGroupName(groupName);
    }

    /**
     * создать студента (принимает JSON) (отладиться можно с помощью Postman)
     * @param student
     * @return
     */
    @PostMapping(value = "/student", produces = MediaType.APPLICATION_JSON_VALUE)
    public Student addStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    /**
     * удалить студента
     * @param id
     */
    @DeleteMapping(value = "/student/{id}")
    public void deleteStudent(@PathVariable long id) {
        studentService.deleteStudentById(id);
    }
}
