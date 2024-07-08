package ru.app.third.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.app.third.dto.User;
import ru.app.third.repository.UserRepository;

@Service("notificationService")
@RequiredArgsConstructor
public class NotificationService {
    private final UserRepository userRepository;

    public void sendNotificationInConsole(User user, String message) {
        System.out.println(user);
        System.out.println(message);
    }

    public void sendNotificationInConsole(String message) {
        System.out.println(message);
    }
}
