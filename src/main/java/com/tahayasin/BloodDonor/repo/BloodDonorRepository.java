package com.tahayasin.BloodDonor.repo;

import com.tahayasin.BloodDonor.domain.AppUser;
import com.tahayasin.BloodDonor.domain.BloodDonor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BloodDonorRepository extends PagingAndSortingRepository<BloodDonor, Long> {
    Optional<BloodDonor> findByAppUserUsername(String username);

    Page<BloodDonor> findByBloodGroupAndAddressPincode(String bloodGroup, String pincode, Pageable pageable);
    //Page<BloodDonor> findByBloodGroupAndAddressCityOrAddressPincode(String bloodGroup, String city, String pincode, Pageable pageable);
    List<BloodDonor> findByBloodGroupAndAddressCityOrAddressPincode(String bloodGroup, String city, String pincode, Pageable pageable);
}
