package ru.app.third.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.app.third.dto.User;
import ru.app.third.service.NotificationService;
import ru.app.third.service.RegistrationService;
import ru.app.third.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final RegistrationService registrationService;
    private final UserService userService;
    private final NotificationService notificationService;

    @RequestMapping()
    public List<User> getUsers() {
        notificationService.sendNotificationInConsole("Запрос по URL://<server>/users");
        return userService.getAllUsers();
    }

    @PostMapping(value = "/body", produces = MediaType.APPLICATION_JSON_VALUE)
    public void createUser(User user) {
        notificationService.sendNotificationInConsole("Запрос по URL://<server>/users/body");
        registrationService.processRegistration(user);
    }
}
