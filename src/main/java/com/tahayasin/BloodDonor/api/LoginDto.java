package com.tahayasin.BloodDonor.api;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginDto {
    private String username;
    private String roleName;
}
