package ru.app.sixth.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.app.sixth.model.Note;
import ru.app.sixth.service.NoteService;

@RestController
@RequestMapping("/note")
@RequiredArgsConstructor
public class NoteController {

    private final NoteService noteService;

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(description = "Создание заметки")
    @ApiResponse(responseCode = "200", description = "Заметка успешно добавлена")
    public Note createNote(Note note) {
        return noteService.create(note);
    }

    @GetMapping(value = "/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(description = "Получение заметки по id")
    @ApiResponse(responseCode = "200", description = "Заметка успешно получена")
    @ApiResponse(responseCode = "404", description = "Заметка не найдена")
    public Note getNote(@PathVariable Long id) {
        if (noteService.getById(id) == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Заметка с ID " + id + " не найдена");
        }
        return noteService.getById(id);
    }

    @GetMapping(value = "/get/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(description = "Получение всех заметок")
    @ApiResponse(responseCode = "200", description = "Заметки успешно получены")
    @ApiResponse(responseCode = "404", description = "Заметки не найдены")
    public Iterable<Note> getAllNotes() {
        if (noteService.getAll().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Заметки не найдены");
        }
        return noteService.getAll();
    }

    @PostMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(description = "Обновление заметки")
    @ApiResponse(responseCode = "200", description = "Заметка успешно обновлена")
    @ApiResponse(responseCode = "404", description = "Заметка не найдена")
    public Note updateNote(Note note) {
        if (noteService.getById(note.getId()) == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Заметка с ID " + note.getId() + " не найдена");
        }
        return noteService.update(note);
    }

    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(description = "Удаление заметки")
    @ApiResponse(responseCode = "200", description = "Заметка успешно удалена")
    @ApiResponse(responseCode = "404", description = "Заметка не найдена")
    public Note deleteNote(@PathVariable Long id) {
        if (noteService.getById(id) == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Заметка с ID " + id + " не найдена");
        }
        return noteService.deleteById(id);
    }
}
