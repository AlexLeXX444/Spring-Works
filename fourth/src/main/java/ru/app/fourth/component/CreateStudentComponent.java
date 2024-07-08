package ru.app.fourth.component;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import ru.app.fourth.dto.Student;
import ru.app.fourth.service.StudentService;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
@RequiredArgsConstructor
public class CreateStudentComponent implements ApplicationRunner {

    private final StudentService studentService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<Student> studentList = new ArrayList<>();
        String[] groups = {"Main", "Second", "Third"};
        Random rnd = new Random();

        for (int i = 0; i < 10; i++) {
            int groupIndex = rnd.nextInt(groups.length);
            Student student = new Student();
            student.setName("Student number " + i);
            student.setGroupName(groups[groupIndex]);
            studentService.saveStudent(student);
        }
    }
}
