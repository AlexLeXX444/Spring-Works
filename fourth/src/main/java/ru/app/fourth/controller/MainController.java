package ru.app.fourth.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.app.fourth.dto.Student;
import ru.app.fourth.service.StudentService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final StudentService studentService;

    @GetMapping("/")
    public String index(Model model){
        List<Student> students = studentService.getAll();
        model.addAttribute("students", students);
        return "index";
    }
}


