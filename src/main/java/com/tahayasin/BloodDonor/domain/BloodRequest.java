package com.tahayasin.BloodDonor.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BloodRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;

    @ManyToOne
    @JoinColumn(name = "donor_id")
    private BloodDonor donor;

    @ManyToOne
    @JoinColumn(name = "recipient_id")
    private BloodRecipient recipient;

    //private Timestamp generatedAt;
    private LocalDateTime generatedAt;
    private boolean isActive;
    private String status;


}
