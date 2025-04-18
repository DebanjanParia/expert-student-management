package com.Student.management.controller;

import com.Student.management.model.CourseModel;
import com.Student.management.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping("/create-course")
    public ResponseEntity<CourseModel> createNewCourse(@RequestBody CourseModel model){
        return new ResponseEntity<>(courseService.createCourse(model), HttpStatus.valueOf(200));
    }

    @GetMapping("/course-details/id")
    public ResponseEntity<CourseModel> getCourseByCourseId(@RequestParam long courseId){
        return new ResponseEntity<>(courseService.getCourseDetailsByCourseId(courseId), HttpStatus.valueOf(200));
    }

    @GetMapping("/course-details/name")
    public ResponseEntity<List<CourseModel>> getCourseByName(@RequestParam String courseName){
       // return (List<ResponseEntity<CourseModel>>) ResponseEntity.ok(courseService.getCourseDetailsByCourseName(courseName));
        return ResponseEntity.ok(courseService.getCourseDetailsByCourseName(courseName));

    }





}
