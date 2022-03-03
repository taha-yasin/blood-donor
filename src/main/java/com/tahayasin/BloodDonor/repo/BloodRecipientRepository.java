package com.tahayasin.BloodDonor.repo;

import com.tahayasin.BloodDonor.domain.BloodRecipient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BloodRecipientRepository extends JpaRepository<BloodRecipient, Long> {
}
