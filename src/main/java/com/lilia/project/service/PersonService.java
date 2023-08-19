package com.lilia.project.service;


import com.lilia.project.entity.Person;
import com.lilia.project.entity.PersonRole;
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

    public void save(PersonRole role, String lastName) {
        Person person = new Person();
        person.setLastName(lastName);
        person.setRole(role);
        personRepo.saveAndFlush(person);
    }

    public Optional<Person> getRequireById(int personId) {
        return personRepo.findById(personId);
    }

    public List<Person> getRequireByRole(PersonRole role) {
        List<Person> people = personRepo.findAll();
        return people.stream()
                .filter(i -> i.getRole().equals(role))
                .toList();
    }


    public PersonRole getRole(int choiceRole) {
        if (choiceRole == 1) {
            return PersonRole.TEACHER;
        } else {
            return PersonRole.STUDENT;
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

