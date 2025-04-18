package com.Student.management.controller;

import com.Student.management.model.StudentModel;
import com.Student.management.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.Student.management.model.RequestModel;

import java.util.List;


@RestController
@RequestMapping("api/v1/student")
public class StudentController {

    @Autowired
    private StudentService studentService;


    //localhost:8081/api/v1/student/home
//    @GetMapping("/home")
//    public String home(Model model){
//        model.addAttribute("currentDate", LocalDate.now());
//        model.addAttribute("message", "Hello, Thymeleaf!");
//        return "home";
//    }

    @PostMapping("/new-registration")
    public ResponseEntity<StudentModel> newStudentRegistration(@RequestBody StudentModel studentModel){
        return ResponseEntity.status(200).body(studentService.newStudentRegistration(studentModel));
    }


    @PostMapping("/get-student-Details")
    public ResponseEntity<StudentModel> getStudentDetails(@RequestBody RequestModel requestModel){
        return ResponseEntity.status(200).body(studentService.getStudentDetails(requestModel));
    }


    @PutMapping("/update-student-details/{studentId}")
    public ResponseEntity<StudentModel> updateStudentDetails(@PathVariable long studentId, @RequestBody StudentModel studentModel){
        return new ResponseEntity<>(studentService.editStudentDetails(studentId, studentModel), HttpStatusCode.valueOf(201));
    }


    @DeleteMapping("/delete-student-details/{studentId}")
    public String deleteStudentDetails(@PathVariable long studentId){

        boolean isDeleted = studentService.deleteByStudentId(studentId);
        if(isDeleted){
            return "delete successfully!!!";
        }else {
            return "Id does not exits";
        }
    }

    @GetMapping("/search-by-passing-year")
    public ResponseEntity<List<StudentModel>> searchByPassingYear(@RequestParam int passingYear){
        return new ResponseEntity<>(studentService.sortByPassingYear(passingYear), HttpStatusCode.valueOf(200));
    }


    @GetMapping("/search-by-registration-year")
    public ResponseEntity<List<StudentModel>> searchByRegistrationYear(@RequestParam int registrationYear){
        return new ResponseEntity<>(studentService.sortByRegistrationYear(registrationYear), HttpStatusCode.valueOf(200));
    }



}
