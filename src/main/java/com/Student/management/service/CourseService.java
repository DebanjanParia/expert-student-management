package com.Student.management.service;

import com.Student.management.model.CourseModel;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourseService {

    CourseModel createCourse(CourseModel model);

    public CourseModel getCourseDetailsByCourseId(long courseId);

    public List<CourseModel> getCourseDetailsByCourseName(String name);


}
