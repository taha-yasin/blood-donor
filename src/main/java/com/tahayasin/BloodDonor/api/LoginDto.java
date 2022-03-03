package com.tahayasin.BloodDonor.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginDto {

    private String firstName;
    private String lastName;
    private String gender;
    private Date dateOfBirth;
    private String username;
    private String password;
}
