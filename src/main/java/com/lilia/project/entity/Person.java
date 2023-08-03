package com.lilia.project.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated
    private Role role;

    private String lastName;

    private String firstName;

    private String phone;

    private String email;

    private int courseId;

//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(name = "student_course",
//            joinColumns = @JoinColumn(name = "student_id"),
//            inverseJoinColumns = @JoinColumn(name = "course_id"))
//    private Set<Course> courses = new HashSet<>();

    public Person() {
    }

    public Person(final Integer id, final Role role, String lastName) {
        this.id = id;
        this.role = role;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "\n Person{" +
                "\n id = " + id +
                "\n role = " + role +
                "\n Last name = " + lastName +
                "\n First name = " + firstName +
                "\n courseId = " + courseId +
                "\n Phone = " + phone +
                "\n Email = " + email +
                "\n }";
    }
}
