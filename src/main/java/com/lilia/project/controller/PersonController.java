package com.lilia.project.controller;

import com.lilia.project.entity.Person;
import com.lilia.project.entity.PersonRole;
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
        if (person.getRole().equals(PersonRole.TEACHER)) {
            return "person/teacher";
        } else
            return "person/student";

    }

    @PostMapping("/teachers/add")
    public String addTeacher(@Valid String lastName) {
        personService.save(PersonRole.TEACHER, lastName);
        return "redirect:/teachers";
    }

    @PostMapping("/students/add")
    public String addStudent(@Valid String lastName) {
        personService.save(PersonRole.STUDENT, lastName);
        return "redirect:/students";
    }

    @GetMapping("/teachers/add")
    public String returnAddTeacherPage() {
        return "person/add";
    }

    @GetMapping("/students/add")
    public String returnAddStudentsPage() {
        return "person/add";
    }

    @GetMapping("/teachers")
    public String allTeachers(Model model) {
        model.addAttribute("teachers", personService.getRequireByRole(PersonRole.TEACHER));
        model.addAttribute("role", PersonRole.TEACHER);
        return "person/teachers";
    }

    @GetMapping("/students")
    public String allStudent(Model model) {
        model.addAttribute("students", personService.getRequireByRole(PersonRole.STUDENT));
        model.addAttribute("role", PersonRole.STUDENT);
        return "person/students";
    }

}
