package ru.app.third.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.app.third.dto.User;
import ru.app.third.repository.UserRepository;

@Service("registrationService")
@RequiredArgsConstructor
public class RegistrationService {

    private final UserRepository userRepository;
    private final NotificationService notificationService;

    public void processRegistration(User user) {
        userRepository.save(user);
        notificationService.sendNotificationInConsole(user, "Успешно зарегистрирован");
    }
}
