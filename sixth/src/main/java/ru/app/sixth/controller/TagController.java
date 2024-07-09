package ru.app.sixth.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.app.sixth.model.Tag;
import ru.app.sixth.service.TagService;

@RestController
@RequestMapping("/tag")
@RequiredArgsConstructor
public class TagController {

    private final TagService tagService;

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(description = "Создание тега")
    @ApiResponse(responseCode = "200", description = "Тег успешно добавлен")
    public Tag createTag(Tag tag) {
        return tagService.create(tag);
    }

    @GetMapping(value = "/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(description = "Получение тега по id")
    @ApiResponse(responseCode = "200", description = "Тег успешно получен")
    @ApiResponse(responseCode = "404", description = "Тег не найден")
    public Tag getTagById(@PathVariable Long id) {
        if (tagService.getById(id) == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Тег с ID " + id + " не найден");
        }
        return tagService.getById(id);
    }

    @GetMapping(value = "/get/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(description = "Получение всех тегов")
    @ApiResponse(responseCode = "200", description = "Теги успешно получены")
    @ApiResponse(responseCode = "404", description = "Теги не найдены")
    public Iterable<Tag> getAllTags() {
        if (tagService.getAll().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Теги не найдены");
        }
        return tagService.getAll();
    }

    @PostMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(description = "Обновление тега")
    @ApiResponse(responseCode = "200", description = "Тег успешно обновлен")
    @ApiResponse(responseCode = "404", description = "Тег не найден")
    public Tag updateTag(Tag tag) {
        if (tagService.getById(tag.getId()) == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Тег не найден");
        }
        return tagService.update(tag);
    }

    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(description = "Удаление тега")
    @ApiResponse(responseCode = "200", description = "Тег успешно удален")
    @ApiResponse(responseCode = "404", description = "Тег не найден")
    public Tag deleteTag(@PathVariable Long id) {
        if (tagService.getById(id) == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Тег не найден");
        }
        return tagService.deleteById(id);
    }
}
