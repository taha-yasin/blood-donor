package com.tahayasin.BloodDonor.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BloodRecipient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long recipient_id;

    @OneToOne
    private AppUser appUser;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "bloodRecipient")
    private Set<BloodRequest> bloodRequests;




}
