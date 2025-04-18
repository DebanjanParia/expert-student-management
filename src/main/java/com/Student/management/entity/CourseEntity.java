package com.Student.management.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "course_details")
@Getter
@Setter
public class CourseEntity {

 //   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column(name = "course_id")
    private long courseId;

    @Column(name = "course_name")
    private String courseName;

    @Column(name = "description")
    private String description;

    @Column(name = "mentor_name")
    private String mentorName;

    @Column(name = "price")
    private long price;


}
