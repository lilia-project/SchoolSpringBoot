package com.lilia.project.controller;

import com.lilia.project.entity.Course;
import com.lilia.project.service.CourseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;


@Controller
public class CourseController {
    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }


    @GetMapping("/course/{id}")
    public String getCourse(Model model, @PathVariable Integer id) {
        final Optional<Course> courseById = courseService.getRequireById(id);
        final Course course = courseById.orElse(null);
        model.addAttribute("course", course);
        model.addAttribute("id", id);
        return "course/course";
    }

    @PostMapping("/courses/add")
    public String addCourse(@Valid String name) {
        courseService.save(name);
        return "redirect:/courses";
    }

    @GetMapping("/courses/add")
    public String returnAddCoursePage() {
        return "course/add";
    }

    @GetMapping("/courses")
    public String allCourses(Model model) {
        model.addAttribute("courses", courseService.outputAll());
        return "course/courses";
    }

    @GetMapping("/courses/delete/{id}")
    public String deleteCourseById(Model model, @PathVariable Integer id) {
        final Optional<Course> courseById = courseService.getRequireById(id);
        final Course course = courseById.orElse(null);
        courseService.delete(course);
        return "redirect:/courses";
    }

    @PostMapping("/edit/{id}")
    public String postEditCourse(@PathVariable Integer id, Model model, Course course) {
        final Optional<Course> courseById = courseService.getRequireById(id);
        if (courseById.isEmpty()) {
            throw new IllegalStateException();
        }
        final Course course1 = courseById.get();
        course1.setName(course.getName());
        courseService.save(course1.getName());
        return "redirect:/courses";
    }

    @GetMapping("/index")
    public String Home() {
        return "redirect:/";
    }

}
