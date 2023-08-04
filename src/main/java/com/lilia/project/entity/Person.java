package com.lilia.project.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private Role role;
    @NotBlank(message = "Name can not be Blank")
    private String lastName;

    private String firstName;
    private String phone;
    @Email
    private String email;

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
                "\n Phone = " + phone +
                "\n Email = " + email +
                "\n }";
    }
}
