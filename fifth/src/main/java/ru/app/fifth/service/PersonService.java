package ru.app.fifth.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.app.fifth.dto.Person;
import ru.app.fifth.repository.PersonRepository;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;

    public void savePerson(Person person) {
        personRepository.save(person);
    }

    public Person getPerson(Long id) {
        return personRepository.findById(id).orElse(null);
    }

    public void updatePerson(Person person) {
        personRepository.save(person);
    }

    public void deletePerson(Long id)  {
        personRepository.deleteById(id);
    }
}
