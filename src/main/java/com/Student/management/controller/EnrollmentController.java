package com.Student.management.controller;

import com.Student.management.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/enrollment")
public class EnrollmentController {

    @Autowired
    private EnrollmentService enrollService;


    @PostMapping("/enroll/{courseId}/{studentId}")
    public ResponseEntity<String> enrollStudent(@RequestParam long courseId, @RequestParam long studentId){
        return new ResponseEntity<>(enrollService.courseEnrollment(courseId, studentId), HttpStatusCode.valueOf(201));

    }
}
