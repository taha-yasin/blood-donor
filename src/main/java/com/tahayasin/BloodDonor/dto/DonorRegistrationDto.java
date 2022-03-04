package com.tahayasin.BloodDonor.dto;

import com.tahayasin.BloodDonor.domain.Address;
import com.tahayasin.BloodDonor.domain.AppUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Basic;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DonorRegistrationDto {
    private AppUser appUser;
    private String bloodGroup;
    private Address address;
    private String whatsAppNumber;
    private Date lastDonationDate;
}
