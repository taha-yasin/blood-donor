package com.tahayasin.BloodDonor.repo;

import com.tahayasin.BloodDonor.domain.AppUser;
import com.tahayasin.BloodDonor.domain.BloodDonor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BloodDonorRepository extends JpaRepository<BloodDonor, Long> {
    Optional<BloodDonor> findByAppUserUsername(String username);
}
