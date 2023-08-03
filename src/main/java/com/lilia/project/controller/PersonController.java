package com.lilia.project.controller;

import com.lilia.project.entity.Person;
import com.lilia.project.entity.Role;
import com.lilia.project.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/person/add")
    public String addPerson(@RequestParam String firstName,
                            @RequestParam String lastName,
                            @RequestParam Role role,
                            @RequestParam String phone,
                            @RequestParam String email) {
        Person person = new Person();
        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setRole(role);
        person.setPhone(phone);
        person.setEmail(email);
        personService.save(person.getLastName());
        return "redirect:/students";
    }

    @GetMapping("/person/{id}")
    public String getPerson(Model model, @PathVariable Integer id) {
        final Optional<Person> personById = personService.getRequireById(id);
        final Person person = personById.orElse(null);
        model.addAttribute("person", person);
        model.addAttribute("id", id);
        return "person/person";
    }

    @GetMapping("/students")
    public String allStudent(Model model) {
        model.addAttribute("people", personService.outputAll());
        return "person/people";
    }

    @GetMapping("/teachers")
    public String allTeacher(Model model) {
        model.addAttribute("people", personService.outputAll());
        return "person/people";
    }

}
