package com.lilia.project.service;

import com.lilia.project.entity.Course;
import com.lilia.project.repo.CourseRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepo courseRepo;

    public void save(String name) {
        Course course = new Course();
        course.setName(name);
        courseRepo.saveAndFlush(course);
    }

    public List<Course> outputAll() {
        return courseRepo.findAll();
    }

    public Optional<Course> getRequireById(int courseId) {
        return courseRepo.findById(courseId);
    }

    public void deleteById(int courseId) {
        courseRepo.deleteById(courseId);
    }

    public void delete(Course course) {
        courseRepo.delete(course);
    }

}
