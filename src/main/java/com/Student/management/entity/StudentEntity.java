package com.Student.management.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.engine.internal.Cascade;

import java.sql.Timestamp;


@Data
@Getter
@Setter
@Entity
@Table(name = "student_details")
public class StudentEntity {

    ////id, Name, studentId, address, mobNo, email, resistrationNo, resistration_year,
    //// regi_date, passing_year, isPassed, lastModifiedDate

//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
//    private long id;

    @Id
    @Column(name = "student_id", nullable = true)
    private long studentId;

    @Column(name = "first_name", nullable = false)
    private  String firstName;

    @Column(name = "last_name", nullable = true)
    private String lastName;

    @Column(name = "gender", nullable = true)
    private String gender;

    @OneToOne(cascade = CascadeType.ALL)
    //@Column(name = "address", nullable = true)
    @PrimaryKeyJoinColumn
    private AddressEntity address;

    @Column(name = "mobile_number", nullable = true)
    private long mobileNumber;

    @Column(name = "email", nullable = true, unique = true)
    private String email;

    @Column(name = "registration_number", nullable = true)
    private long registrationNumber;

    @Column(name = "registration_year", nullable = true)
    private long registrationYear;

    @Column(name = "registration_date", nullable = true)
    private String registrationDate;

    @Column(name = "passing_year", nullable = true)
    private long passingYear;

    @Column(name = "is_passed", nullable = true)
    private boolean isPassed;

    @Column(name = "is_pursued", nullable = true)
    private boolean isPursued;

    @Column(name = "last_modified_date", nullable = true)
    private Timestamp lastModifiedDate;



}
