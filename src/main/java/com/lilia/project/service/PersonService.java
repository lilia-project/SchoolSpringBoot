package com.lilia.project.service;


import com.lilia.project.entity.Person;
import com.lilia.project.entity.Role;
import com.lilia.project.repo.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    private final PersonRepo personRepo;

    @Autowired
    public PersonService(PersonRepo PersonRepo) {
        this.personRepo = PersonRepo;
    }

    public void save(String name) {
        Person person = new Person();
        person.setLastName(name);
        personRepo.saveAndFlush(person);
    }

    public Optional<Person> getRequireById(int personId) {
        return personRepo.findById(personId);
    }

    public Role getRole(int choiceRole) {
        if (choiceRole == 1) {
            return Role.TEACHER;
        } else {
            return Role.STUDENT;
        }
    }

    public List<Person> outputAll() {
        return personRepo.findAll();
    }

    public void delete(String lastName) {
        Person person = new Person();
        person.setLastName(lastName);
        personRepo.delete(person);

    }

}

