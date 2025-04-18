package com.Student.management.service;

import com.Student.management.model.EnrollmentModel;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public interface EnrollmentService {

   // String courseEnrollment(Long studentId, Long courseId, EnrollmentModel enrollModel);

    public String courseEnrollment(long courseId, long studentId);
}
