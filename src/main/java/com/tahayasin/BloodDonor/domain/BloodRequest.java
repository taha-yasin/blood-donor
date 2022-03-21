package com.tahayasin.BloodDonor.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BloodRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long request_id;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "donor_request",
            joinColumns = @JoinColumn(name = "request_id",
                    referencedColumnName = "request_id"),
            inverseJoinColumns = @JoinColumn(name = "donor_id",
                    referencedColumnName = "donor_id"))
    private Set<BloodDonor> bloodDonors;

    @ManyToOne
    @JoinColumn(name = "recipient_id")
    private BloodRecipient bloodRecipient;
    //private AppUser appUser;

    //private Timestamp generatedAt;
    private LocalDateTime generatedAt;
    private boolean isActive;
    private String status;


}
