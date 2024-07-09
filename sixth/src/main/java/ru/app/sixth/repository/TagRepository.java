package ru.app.sixth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.app.sixth.model.Tag;

public interface TagRepository extends JpaRepository<Tag, Long> {
}
