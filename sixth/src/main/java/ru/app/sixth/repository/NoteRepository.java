package ru.app.sixth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.app.sixth.model.Note;

public interface NoteRepository extends JpaRepository<Note, Long>{
}
