package com.lilia.project.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Data
public class Lecture implements Serializable {
    private static final DateTimeFormatter DTF = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @PastOrPresent
    private LocalDateTime createdAt;
    @FutureOrPresent
    private LocalDateTime lectureDate;
    @NotBlank
    @Size(min = 3, max = 30)
    private String name;
    @Size(min = 0, max = 300)
    private String description;

    public Lecture() {
    }

    public Lecture(final Integer id, String name) {
        this.id = id;
        this.name = name;
        this.createdAt = LocalDateTime.now();
        this.lectureDate = LocalDateTime.now().plusDays((int) (Math.random() * 10));
    }

    public Lecture(Integer id, LocalDateTime createdAt, LocalDateTime lectureDate, String name, int courseId, int personId, String description) {
        this.id = id;
        this.createdAt = createdAt;
        this.lectureDate = lectureDate;
        this.name = name;
        this.description = description;
    }

    @Override
    public String toString() {
        return " Lecture{" +
                " id=" + id +
                " createdAt=" + createdAt.format(DTF) +
                " lectureDate=" + lectureDate.format(DTF) +
                " name='" + name + '\'' +
                " description='" + description + '\'' +
                '}';
    }
}
