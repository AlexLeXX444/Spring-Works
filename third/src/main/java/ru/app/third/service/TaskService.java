package ru.app.third.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.app.third.dto.User;
import ru.app.third.repository.UserRepository;

import java.util.Comparator;
import java.util.List;

@Service("taskService")
@RequiredArgsConstructor
@RequestMapping("/tasks")
public class TaskService {

    private final UserRepository userRepository;
    private final NotificationService notificationService;

    public List<User> getAllSortByAge() {
        List<User> users = userRepository.findAll();
        Comparator<User> ageComparator = Comparator.comparingInt(User::getAge);
        users.sort(ageComparator);
        notificationService.sendNotificationInConsole("Отправлен список пользователей с спортировкой по возрасту.");
        return users;
    }

    public List<User> filterUsersByAge(int age) {
        notificationService.sendNotificationInConsole("Отправлен список пользователей определенного возраста.");
        return userRepository.findAllByAge(age);
    }

    public int calculateAverageAge()  {
        notificationService.sendNotificationInConsole("Отправлено среднее значение всех пользователей.");
        List<User> users = userRepository.findAll();
        int averageAge = 0;

        for (User user : users) {
            averageAge += user.getAge();
        }
        return averageAge/users.size();
    }
}
