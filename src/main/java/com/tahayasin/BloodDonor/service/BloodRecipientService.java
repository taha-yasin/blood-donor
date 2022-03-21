package com.tahayasin.BloodDonor.service;

import com.tahayasin.BloodDonor.domain.AppUser;
import com.tahayasin.BloodDonor.domain.BloodDonor;
import com.tahayasin.BloodDonor.domain.BloodRecipient;
import com.tahayasin.BloodDonor.domain.BloodRequest;
import com.tahayasin.BloodDonor.repo.AppUserRepository;
import com.tahayasin.BloodDonor.repo.BloodDonorRepository;
import com.tahayasin.BloodDonor.repo.BloodRecipientRepository;
import com.tahayasin.BloodDonor.repo.BloodRequestRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BloodRecipientService {
    private final BloodDonorRepository bloodDonorRepository;
    private final BloodRecipientRepository bloodRecipientRepository;
    private final BloodRequestRepository bloodRequestRepository;
    private final AppUserRepository appUserRepository;
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


    public void requestBlood(Set<Long> donorIds) {
        Long userId = appUserService.getAuthenticatedUserId();

        AppUser appUser = appUserRepository.findById(userId).get();
        BloodRecipient bloodRecipient = new BloodRecipient();
        bloodRecipient.setAppUser(appUser);
        bloodRecipient = bloodRecipientRepository.save(bloodRecipient);

//        Set<BloodDonor> bloodDonors = donorIds.stream().map(id ->
//                bloodDonorRepository.findById(id).get()).collect(Collectors.toSet());

//        Long userId = appUserService.getAuthenticatedUserId();
//
//        AppUser appUser = appUserRepository.findById(userId).get();

        BloodRequest bloodRequest = new BloodRequest();     //TODO: Add Arguments
        bloodRequest.setBloodRecipient(bloodRecipient);
        bloodRequest.setBloodDonors(bloodDonorRepository.findDonorByListOfIds(donorIds));
        bloodRequest = bloodRequestRepository.save(bloodRequest);

    }

}
