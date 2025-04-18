package com.Student.management.model;

import com.Student.management.entity.AddressEntity;
import com.Student.management.entity.StudentEntity;
import lombok.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Random;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
 public class StudentModel {


//id, Name, studentId, address, mobNo, email, resistrationNo, resistration_year,
// regi_date, passing_year, isPassed, lastModifiedDate

    //private long id;
    private long studentId;
    private String firstName;
    private String lastName;
    private String gender;
    private AddressEntity address;
    private long mobileNumber;
    private String email;
    private long registrationNumber;
    private long registrationYear;
    private String registrationDate;
    private long passingYear;
    private boolean isPassed;
    private boolean isPursued;
    private Timestamp lastModifiedDate;


    public void mapModelToEntity(StudentEntity studentEntity){

        AddressEntity addressEntity = new AddressEntity();
        Random random = new Random();
        long studentId = 100000 + random.nextLong(900000);
        String studentIdstr = String.valueOf(studentId);
        int threeDigitId = Integer.parseInt(studentIdstr.substring(1,5));

        long min = 1000000000L; // Define a minimum value
        long max = 9999999999L; // Define a maximum value
        long randomLongInRange = min + (long) (random.nextDouble() * (max - min));

        studentEntity.setStudentId(studentId);
        studentEntity.setLastName(this.getLastName());
        studentEntity.setFirstName(this.getFirstName());
        studentEntity.setGender(this.getGender());
        studentEntity.setMobileNumber(this.getMobileNumber());

        addressEntity.setStudentId(studentId);
        addressEntity.setVillage(this.getAddress().getVillage());
        addressEntity.setTown(this.getAddress().getTown());
        addressEntity.setState(this.getAddress().getState());
        addressEntity.setPoliceStation(this.getAddress().getPoliceStation());
        addressEntity.setPinCode(this.getAddress().getPinCode());

        studentEntity.setAddress(addressEntity);
        studentEntity.setEmail(this.getEmail());
        studentEntity.setRegistrationNumber(threeDigitId+randomLongInRange);

        if(this.isPassed) {
            studentEntity.setPassed(true);
        }
        if(this.isPursued()) {
            studentEntity.setPursued(true);
        }
        studentEntity.setPassingYear(this.getPassingYear());

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        studentEntity.setLastModifiedDate(timestamp);

        String s = timestamp.toString().substring(0,10);
        studentEntity.setRegistrationDate(s);
        studentEntity.setRegistrationYear(Long.parseLong(s.substring(0,4)));

    }

    public StudentModel mapEntityToModel(StudentEntity studentEntity){


        AddressEntity addressEntity = new AddressEntity();

        this.setLastName(studentEntity.getLastName());
        this.setGender(studentEntity.getGender());
        this.setFirstName(studentEntity.getFirstName());
        this.setMobileNumber(studentEntity.getMobileNumber());
        this.setAddress(studentEntity.getAddress());
        this.setEmail(studentEntity.getEmail());
        this.setRegistrationNumber(studentEntity.getRegistrationNumber());
        this.setRegistrationDate(studentEntity.getRegistrationDate());
        this.setRegistrationYear(studentEntity.getRegistrationYear());
        this.setPassed(studentEntity.isPassed());
        this.setPursued(studentEntity.isPursued());
        this.setPassingYear(studentEntity.getPassingYear());
        this.setLastModifiedDate(studentEntity.getLastModifiedDate());
        this.setStudentId(studentEntity.getStudentId());

        return this;

    }

}
