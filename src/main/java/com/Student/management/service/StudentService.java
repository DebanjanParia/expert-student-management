package com.Student.management.service;

import com.Student.management.model.RequestModel;
import com.Student.management.model.StudentModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {


    public StudentModel newStudentRegistration(StudentModel studentModel);

    public StudentModel getStudentDetails(RequestModel requestBody);

    public StudentModel editStudentDetails(long studentId, StudentModel studentModel);

   // public String deleteStudentDetails(long studentId);

    public boolean deleteByStudentId(long studentId);

    public List<StudentModel> sortByPassingYear(int passingYear);

    public List<StudentModel> sortByRegistrationYear(int registrationYear);


}
