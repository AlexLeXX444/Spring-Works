package ru.app.third.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.app.third.dto.User;
import ru.app.third.service.NotificationService;
import ru.app.third.service.TaskService;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class UserTaskController {

    private final TaskService taskService;
    private final NotificationService notificationService;

    @GetMapping("/sort")
    public List<User> getAllSortByAge() {
        notificationService.sendNotificationInConsole("Запрос по URL://<server>/tasks/sort");
        return taskService.getAllSortByAge();
    }

    @GetMapping(value = "/filter/{age}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getAllByAge(@PathVariable int age)  {
        notificationService.sendNotificationInConsole("Запрос по URL://<server>/tasks/filter/" + age);
        return taskService.filterUsersByAge(age);
    }

    @GetMapping("/calc")
    public int getAverageAge() {
        notificationService.sendNotificationInConsole("Запрос по URL://<server>/tasks/calc");
        return taskService.calculateAverageAge();
    }
}
