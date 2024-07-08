package ru.app.third.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.app.third.dto.User;
import ru.app.third.repository.UserRepository;

import java.util.List;

@Service("userService")
@RequiredArgsConstructor
@RequestMapping("/")
public class UserService {

    private final UserRepository userRepository;
    private final NotificationService notificationService;

    public List<User> getAllUsers() {
        notificationService.sendNotificationInConsole("Запрос списка пользователей");
        return userRepository.findAll();
    }
}
