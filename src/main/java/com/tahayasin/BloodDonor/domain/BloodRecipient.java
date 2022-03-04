package com.tahayasin.BloodDonor.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BloodRecipient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long recipient_id;

    @OneToOne
    private AppUser appUser;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "recipient")
    private Set<BloodRequest> bloodRequests;




}
