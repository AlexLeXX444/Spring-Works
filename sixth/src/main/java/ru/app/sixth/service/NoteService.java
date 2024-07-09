package ru.app.sixth.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.app.sixth.model.Note;
import ru.app.sixth.repository.NoteRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoteService implements CrudOptions<Note>{

    private final NoteRepository noteRepository;

    @Override
    public Note create(Note entity) {
        return noteRepository.save(entity);
    }

    @Override
    public Note getById(Long id) {
        return noteRepository.findById(id).orElse(null);
    }

    @Override
    public List<Note> getAll() {
        return noteRepository.findAll();
    }

    @Override
    public Note update(Note entity) {
        if (noteRepository.existsById(entity.getId())) {
            return noteRepository.save(entity);
        }
        return null;
    }

    @Override
    public Note deleteById(Long id) {
        if (noteRepository.existsById(id)) {
            Note note = noteRepository.findById(id).orElse(null);
            noteRepository.deleteById(id);
            return note;
        }
        return null;
    }
}
