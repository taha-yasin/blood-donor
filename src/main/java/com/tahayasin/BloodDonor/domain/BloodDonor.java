package com.tahayasin.BloodDonor.domain;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.Set;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BloodDonor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long donor_id;

    @OneToOne
    private AppUser appUser;
    private String bloodGroup;
    private Address address;
    private String whatsAppNumber;

    @Basic
    private Date lastDonationDate;

//    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "donor")
//    private Set<BloodRequest> bloodRequests;

    @ManyToMany(mappedBy = "bloodDonors")
    private Set<BloodRequest> bloodRequests;


    public BloodDonor(AppUser user, String bloodGroup, Address address, String whatsAppNumber, Date lastDonationDate) {
        this.appUser = user;
        this.bloodGroup = bloodGroup;
        this.address = address;
        this.whatsAppNumber = whatsAppNumber;
        this.lastDonationDate = lastDonationDate;
    }
}
