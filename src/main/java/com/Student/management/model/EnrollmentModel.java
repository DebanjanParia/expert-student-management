package com.Student.management.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class EnrollmentModel {

    private String studentName;
    private String email;
    private long mobileNumber;
    private long studentId;

}
