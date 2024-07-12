package ru.app.sewens.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class MainController {

    @GetMapping
    public String index() {
        return "Hello World!";
    }

    @GetMapping("/all")
    public String test() {
        return "Hello All!";
    }

    @GetMapping("/user")
    public String user() {
        return "Hello User!";
    }

    @GetMapping("/admin")
    public String admin() {
        return "Hello Admin!";
    }
}
