package com.shabanov.example.controller;


import com.shabanov.example.entity.Person;
import com.shabanov.example.servise.PersonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {
    PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public List<Person> getAll() {
        return personService.getAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Person getPerson(@PathVariable int id) {
        return personService.getPerson(id);
    }

    @PostMapping
    public int addPerson(@RequestBody Person person) {
        return personService.addPerson(person);
    }
}
