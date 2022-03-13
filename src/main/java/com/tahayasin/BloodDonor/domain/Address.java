package com.tahayasin.BloodDonor.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    private String streetAddress;
    //private String locality;
    private String city;
    private String state;
    private String pincode;

}
