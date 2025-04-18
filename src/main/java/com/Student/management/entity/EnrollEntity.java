package com.Student.management.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
@Entity
@Table(name = "enrollment")
public class EnrollEntity {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long id;

    @Id
    @Column(name = "enrollment_id", nullable = false)
    private long enrollmentId;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private StudentEntity student;

    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    private CourseEntity course;

    @Column(name = "enroll_date")
    private LocalDateTime enrollTime = LocalDateTime.now();



}
