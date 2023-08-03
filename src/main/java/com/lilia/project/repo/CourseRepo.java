package com.lilia.project.repo;

import com.lilia.project.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepo extends JpaRepository<Course, Integer> {
   /* @Modifying
    @Transactional
    @Query("UPDATE Course course SET course.name = :#{#updatedCourse.name} " +
            "WHERE course.id = :#{#updatedCourse.id}")
    void updateCourse(Course course);*/

}
