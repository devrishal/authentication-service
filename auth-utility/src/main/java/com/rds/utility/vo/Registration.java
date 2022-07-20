package com.rds.utility.vo;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Registration {
    private String firstName;
    private String lastName;
    private String middleName;
    private String city;
    private String country;
    private String line1;
    private String line2;
    private String line3;
    private String state;
    private String email;
    private String username;
    private String password;
    private LocalDate dateOfBirth;

}
