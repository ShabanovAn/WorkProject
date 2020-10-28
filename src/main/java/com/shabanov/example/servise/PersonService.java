package com.shabanov.example.servise;

import com.shabanov.example.entity.Person;
import com.shabanov.example.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Service
public class PersonService {
    PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> getAll() {
        return personRepository.findAll();
    }

    public Person getPerson(int id) {
        return personRepository.findById(id).orElse(null);
    }

    @Transactional
    public int addPerson(Person person) {
        System.out.println(person);
       return personRepository.save(person).getId();

    }
}
