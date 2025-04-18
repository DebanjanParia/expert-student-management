package com.Student.management.service;

import com.Student.management.entity.CourseEntity;
import com.Student.management.entity.EnrollEntity;
import com.Student.management.entity.StudentEntity;
import com.Student.management.repository.CourseRepository;
import com.Student.management.repository.EnrollmentRepository;
import com.Student.management.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class EnrollmentServiceImpl implements EnrollmentService{

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;


    @Override
    public String courseEnrollment(long courseId, long studentId) {

//        if (studentRepository.existsByStudentId(studentId)) {
            StudentEntity student = studentRepository.findByStudentId(studentId);
//        }else {
//            new RuntimeException("Student is not found, please register!!!");
//        }
//        StudentEntity student = studentRepository.findByStudentId(studentId)
//                .orElseThrow(() -> new RuntimeException("Student not found"));

        CourseEntity course = courseRepository.getByCourseId(courseId);


//        if (enrollmentRepository.existsByStudentAndCourse(studentId)) {
//            return "Student is already enrolled in this course!";
//        }

        Random random = new Random();

        EnrollEntity enrollment = new EnrollEntity();
        enrollment.setStudent(student);
        enrollment.setCourse(course);
        enrollment.setEnrollmentId(random.nextInt(1000000,999999999));
        enrollmentRepository.save(enrollment);

        return "Enrollment successful!";

    }
}
