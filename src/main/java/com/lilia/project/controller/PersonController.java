package com.lilia.project.controller;

import com.lilia.project.entity.Person;
import com.lilia.project.entity.Role;
import com.lilia.project.service.PersonService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/person/{id}")
    public String getPerson(Model model, @PathVariable Integer id) {
        final Optional<Person> personById = personService.getRequireById(id);
        final Person person = personById.orElse(null);
        model.addAttribute("person", person);
        model.addAttribute("id", id);
        if (person.getRole().equals(Role.TEACHER)) {
            return "person/teacher";
        } else
            return "person/student";

    }

    @PostMapping("/teachers/add")
    public String addTeacher(@Valid String lastName) {
        personService.save(Role.TEACHER, lastName);
        return "person/teachers";
    }

    @GetMapping("/teachers/add")
    public String returnAddTeacherPage() {
        return "teacher/add";
    }

    @GetMapping("/teachers")
    public String allTeachers(Model model) {
        model.addAttribute("teachers", personService.getRequireByRole(Role.TEACHER));
        model.addAttribute("role", Role.TEACHER);
        return "person/teachers";
    }

    @GetMapping("/students")
    public String allStudent(Model model) {
        model.addAttribute("students", personService.getRequireByRole(Role.STUDENT));
        model.addAttribute("role", Role.STUDENT);
        return "person/students";
    }

}
