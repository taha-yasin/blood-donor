package com.tahayasin.BloodDonor.dto;

import com.tahayasin.BloodDonor.domain.Address;
import com.tahayasin.BloodDonor.domain.BloodDonor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FindDonorDto {
    private Long user_id;
    private String firstName;
    private String lastName;
    private String bloodGroup;
    private int age;
    private String gender;
    private String streetAddress;

    public FindDonorDto(BloodDonor bloodDonor) {
        this(bloodDonor.getAppUser().getUser_id(),
                bloodDonor.getAppUser().getPerson().getFirstName(),
                bloodDonor.getAppUser().getPerson().getLastName(),
                bloodDonor.getBloodGroup(),
                bloodDonor.getAppUser().getPerson().getAge(bloodDonor.getAppUser().getPerson().getDateOfBirth()),
                bloodDonor.getAppUser().getPerson().getGender(),
                bloodDonor.getAddress().getStreetAddress());
    }
}
