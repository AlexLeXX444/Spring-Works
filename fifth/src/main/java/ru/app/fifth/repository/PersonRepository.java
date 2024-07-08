package ru.app.fifth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.app.fifth.dto.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
