package com.rds.utility.vo;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ProfileInformation {
    private String email;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String address;
}
