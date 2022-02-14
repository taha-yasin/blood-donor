package com.tahayasin.BloodDonor.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginDto {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
}
