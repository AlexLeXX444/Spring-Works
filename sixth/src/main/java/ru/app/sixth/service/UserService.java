package ru.app.sixth.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.app.sixth.model.User;
import ru.app.sixth.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements CrudOptions<User> {

    private final UserRepository userRepository;

    @Override
    public User create(User entity) {
        return userRepository.save(entity);
    }

    @Override
    public User getById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User update(User entity) {
        if (userRepository.existsById(entity.getId())) {
            return userRepository.save(entity);
        }
        return null;
    }

    @Override
    public User deleteById(Long id) {
        User user = userRepository.findById(id).get();
        if (userRepository.existsById(id) && !user.getNotes().isEmpty()) {
            userRepository.deleteById(id);
            return user;
        }
        return null;
    }
}
