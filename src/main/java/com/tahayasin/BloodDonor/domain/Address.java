package com.tahayasin.BloodDonor.domain;

import lombok.*;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    private String streetAddress;
    //private String locality;
    private String city;
    private String state;
    private String pincode;

}
