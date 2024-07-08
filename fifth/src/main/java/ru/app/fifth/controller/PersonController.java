package ru.app.fifth.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.app.fifth.dto.Person;
import ru.app.fifth.service.PersonService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public void createPerson(Person person){
        personService.savePerson(person);
    }

    @GetMapping(value  = "/get/{id}", produces  = MediaType.APPLICATION_JSON_VALUE)
    public Person getPerson(Long id){
        return personService.getPerson(id);
    }

    @PostMapping(value  =  "/update/{id}", produces  = MediaType.APPLICATION_JSON_VALUE)
    public void updatePerson(@PathVariable Long id, Person person){
        Person UpdatedPerson = personService.getPerson(id);
        UpdatedPerson.setFirstName(person.getFirstName());
        UpdatedPerson.setLastName(person.getLastName());
        personService.savePerson(UpdatedPerson);
    }

    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deletePerson(@PathVariable Long id){
        personService.deletePerson(id);
    }
}
