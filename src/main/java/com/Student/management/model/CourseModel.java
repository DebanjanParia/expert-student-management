package com.Student.management.model;

import com.Student.management.entity.CourseEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.Random;

@Getter
@Setter
public class CourseModel {


    private long id;

    private long courseId;

    private String courseName;

    private String description;

    private String mentorName;

    private long price;


    public void mapModelToEntity( CourseEntity entity){

        Random random = new Random();
        long courseId = random.nextLong(1000, 9999);

        entity.setCourseId(courseId);
        entity.setCourseName(this.getCourseName());
        entity.setDescription(this.getDescription());
        entity.setMentorName(this.getMentorName());
        entity.setPrice(this.getPrice());

    }

    public CourseModel mapEntityToModel(CourseEntity courseEntity){

        this.setId(courseEntity.getId());
        this.setCourseId(courseEntity.getCourseId());
        this.setCourseName(courseEntity.getCourseName());
        this.setDescription(courseEntity.getDescription());
        this.setMentorName(courseEntity.getMentorName());
        this.setPrice(courseEntity.getPrice());

        return this;
    }


}
