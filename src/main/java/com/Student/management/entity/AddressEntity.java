package com.Student.management.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Address")
//@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddressEntity {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id", nullable = false)
//    private long id;

    @Id
    @Column(name = "student_id", nullable = false)
    private long studentId;

    @Column(name = "village", nullable = true)
    private  String village;

    @Column(name = "town", nullable = true)
    private String town;

    @Column(name = "police_station", nullable = true)
    private String policeStation;

    @Column(name = "state", nullable = true)
    private String state;

    @Column(name = "pin_code", nullable = true)
    private long pinCode;


}
