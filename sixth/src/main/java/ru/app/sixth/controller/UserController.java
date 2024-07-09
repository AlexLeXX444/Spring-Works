package ru.app.sixth.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.app.sixth.model.User;
import ru.app.sixth.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(description = "Создание пользователя")
    @ApiResponse(responseCode = "200", description = "Пользователе добавлен")
    public User create(User user) {
        return userService.create(user);
    }

    @GetMapping(value = "/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(description = "Получение пользователя по id")
    @ApiResponse(responseCode = "200", description = "Пользователь найден")
    @ApiResponse(responseCode = "404", description = "Пользователь не найден")
    public User getById(@PathVariable Long id) {
        if (userService.getById(id) == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Пользователь с ID " + id + " не найден");
        }
        return userService.getById(id);
    }

    @GetMapping(value = "/get/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(description = "Получение всех пользователей")
    @ApiResponse(responseCode = "200", description = "Пользователи найдены")
    @ApiResponse(responseCode = "404", description = "Нет пользователей")
    public List<User> getAll() {
        if (userService.getAll().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Нет пользователей");
        }
        return userService.getAll();
    }

    @PostMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(description = "Обновление пользователя")
    @ApiResponse(responseCode = "200", description = "Пользователь обновлён")
    @ApiResponse(responseCode = "404", description = "Пользователь не существует")
    public User update(User user) {
        if (userService.getById(user.getId()) == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Пользователь с ID " + user.getId() + " не существует");
        }
        return userService.update(user);
    }

    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(description = "Удаление пользователя")
    @ApiResponse(responseCode = "200", description = "Пользователь удалён")
    @ApiResponse(responseCode = "404", description = "Пользователь не существует или имеет связанные заметки")
    public User deleteById(@PathVariable Long id) {
        if (userService.getById(id) == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Пользователь с ID " + id + " не существует или имеет связанные заметки");
        }
        return userService.deleteById(id);
    }
}
