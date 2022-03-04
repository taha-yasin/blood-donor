package com.tahayasin.BloodDonor.dto;

import com.tahayasin.BloodDonor.domain.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginDto {
    //private PersonDto personDto;
    private Person person;
    private String username;
    private String password;
}
