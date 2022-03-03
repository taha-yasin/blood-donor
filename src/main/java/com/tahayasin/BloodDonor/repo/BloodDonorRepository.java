package com.tahayasin.BloodDonor.repo;

import com.tahayasin.BloodDonor.domain.BloodDonor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BloodDonorRepository extends JpaRepository<BloodDonor, Long> {
}
