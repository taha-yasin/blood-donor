package com.tahayasin.BloodDonor.repo;

import com.tahayasin.BloodDonor.domain.AppUser;
import com.tahayasin.BloodDonor.domain.BloodRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BloodRequestRepository extends JpaRepository<BloodRequest, Long> {
    //Optional<BloodRequest> findByUsername(String username);
}
