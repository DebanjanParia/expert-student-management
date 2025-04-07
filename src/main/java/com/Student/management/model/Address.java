package com.Student.management.model;

import jakarta.persistence.Column;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class Address {

    private  String village;

    private String town;

    private String policeStation;

    private String state;

    private long pinCode;


}
