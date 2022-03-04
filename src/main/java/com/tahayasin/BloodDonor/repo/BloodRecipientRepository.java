package com.tahayasin.BloodDonor.repo;

import com.tahayasin.BloodDonor.domain.AppUser;
import com.tahayasin.BloodDonor.domain.BloodRecipient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BloodRecipientRepository extends JpaRepository<BloodRecipient, Long> {
    //Optional<BloodRecipient> findByUsername(String username);
}
