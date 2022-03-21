package com.tahayasin.BloodDonor.domain;

import lombok.*;

import javax.persistence.Basic;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;


@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    private String firstName;
    private String lastName;
    private String gender;

    @Basic
    private Date dateOfBirth;

    public int getAge(Date dateOfBirth) {
        LocalDate birthDate = new Date(dateOfBirth.getTime()).toLocalDate();
        Period period = Period.between(birthDate, LocalDate.now());
        return period.getYears();
    }
}
