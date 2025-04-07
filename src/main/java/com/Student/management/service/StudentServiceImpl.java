package com.Student.management.service;

import com.Student.management.entity.AddressEntity;
import com.Student.management.entity.StudentEntity;
import com.Student.management.model.RequestModel;
import com.Student.management.model.StudentModel;
import com.Student.management.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Service
public class StudentServiceImpl implements StudentService {


    @Autowired
    private StudentRepository studentRepository;

    //private UserModel userModel;

    @Override
    public StudentModel newStudentRegistration(StudentModel studentModel) {


        StudentEntity studentEntity = new StudentEntity();
        studentModel.mapModelToEntity(studentEntity);
        StudentEntity userDetails = studentRepository.save(studentEntity);

        return studentModel.mapEntityToModel(userDetails);
    }

    @Override
    public StudentModel getStudentDetails(RequestModel requestModel) {

        try {
            StudentModel studentModel = new StudentModel();
            StudentEntity entityDetails = studentRepository.findByStudentId(requestModel.getStudentId());
            studentModel.mapEntityToModel(entityDetails);

            return studentModel.mapEntityToModel(entityDetails);
        } catch (RuntimeException e) {
            throw new RuntimeException("cannot find the student details");
        }
    }

    @Override
    public StudentModel editStudentDetails(long studentId, StudentModel studentModel) {

        StudentEntity entityDetails = studentRepository.findByStudentId(studentId);

        entityDetails.setFirstName((studentModel.getFirstName() == null || studentModel.getFirstName().isEmpty() ) ?
                entityDetails.getFirstName(): studentModel.getFirstName());

        entityDetails.setLastName((studentModel.getLastName() == null || studentModel.getLastName().isEmpty() ) ?
                entityDetails.getLastName(): studentModel.getLastName());

        entityDetails.setGender((studentModel.getGender() == null || studentModel.getGender().isEmpty() ) ?
                entityDetails.getGender() : studentModel.getGender());

        AddressEntity entity = studentModel.getAddress();
        entityDetails.setAddress((isBlank(entity)) ?
                entityDetails.getAddress(): studentModel.getAddress());

        entityDetails.setEmail((studentModel.getEmail() == null || studentModel.getEmail().isEmpty() ) ?
                entityDetails.getEmail(): studentModel.getEmail());

        entityDetails.setMobileNumber((studentModel.getMobileNumber() == 0 ) ?
                entityDetails.getMobileNumber(): studentModel.getMobileNumber());

        entityDetails.setPassingYear(studentModel.getPassingYear()== 0 ?
                entityDetails.getPassingYear() : studentModel.getPassingYear());

        entityDetails.setRegistrationYear(studentModel.getRegistrationYear()== 0 ?
                entityDetails.getRegistrationYear() : studentModel.getRegistrationYear());

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        entityDetails.setLastModifiedDate(timestamp);

        StudentEntity userDetails = studentRepository.save(entityDetails);

        return studentModel.mapEntityToModel(userDetails);
    }



    private boolean isBlank(AddressEntity entity) {
        if (entity == null) {
            return true;
        }
        // Check for empty fields
        return (entity.getVillage() == null || entity.getVillage().isEmpty()) &&
                (entity.getTown() == null || entity.getTown().isEmpty()) &&
                (entity.getState() == null || entity.getState().isEmpty()) &&
                (entity.getPinCode() == 0 );
    }



    @Override
    public boolean deleteByStudentId(long studentId){

        if(studentRepository.existsByStudentId(studentId)) {
            studentRepository.deleteById(studentId);
            return true;
        }
        return false;
    }


    @Override
    public List<StudentModel> sortByPassingYear(int passingYear) {

        List<StudentModel> studentModels = new ArrayList<>();
        List<StudentEntity> studentEntity = studentRepository.sortByPassingYear(passingYear);

            for (StudentEntity entity : studentEntity) {
                StudentModel model = new StudentModel();
                model.mapEntityToModel(entity);
                studentModels.add(model);
            }
        return studentModels;
    }


    @Override
    public List<StudentModel> sortByRegistrationYear(int registrationYear) {

        List<StudentModel> studentModels = new ArrayList<>();
        List<StudentEntity> studentEntity = studentRepository.sortByRegistrationYear(registrationYear);

        for (StudentEntity entity : studentEntity) {
            StudentModel model = new StudentModel();
            model.mapEntityToModel(entity);
            studentModels.add(model);
        }
        return studentModels;
    }



}
