package com.tahayasin.BloodDonor.service;

import com.tahayasin.BloodDonor.domain.BloodDonor;
import com.tahayasin.BloodDonor.domain.BloodRequest;
import com.tahayasin.BloodDonor.repo.BloodDonorRepository;
import com.tahayasin.BloodDonor.repo.BloodRecipientRepository;
import com.tahayasin.BloodDonor.repo.BloodRequestRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@AllArgsConstructor
public class BloodRecipientService {
    private final BloodDonorRepository bloodDonorRepository;
    private final BloodRecipientRepository bloodRecipientRepository;
    private final BloodRequestRepository bloodRequestRepository;
    private final AppUserService appUserService;

    public Page<BloodDonor> findDonor(String bloodGroup, String city, String pincode, int pageNo, int pageSize, String sortBy) {

        Pageable pageOfDonors = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).ascending());
        Page<BloodDonor> bloodDonors = bloodDonorRepository.findByBloodGroupAndAddressCityOrAddressPincode(bloodGroup,
                city,
                pincode,
                pageOfDonors);

//        List<BloodDonor> bloodDonors = bloodDonorRepository.findByBloodGroupAndAddressCityOrAddressPincode(bloodGroup, city, pincode, pageOfDonors);

        return bloodDonors;
    }

//    public void requestBlood(List<Long> userIds) {
//        Long donorId = appUserService.getAuthenticatedUserId();
//
//        BloodRequest bloodRequest = new BloodRequest()
//        bloodRequestRepository.save();
//    }
}
