package com.tahayasin.BloodDonor.service;

import com.tahayasin.BloodDonor.domain.*;
import com.tahayasin.BloodDonor.repo.AppRoleRepository;
import com.tahayasin.BloodDonor.repo.AppUserRepository;
import com.tahayasin.BloodDonor.repo.BloodDonorRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BloodDonorService {
    private final BloodDonorRepository bloodDonorRepository;
    private final AppUserRepository appUserRepository;
    private final AppRoleRepository appRoleRepository;
    private final PasswordEncoder passwordEncoder;

    public Optional<BloodDonor> donorRegistration(AppUser appUser,
                                       String bloodGroup,
                                       Address address,
                                       String whatsAppNumber,
                                       Date lastDonationDate) {
        //LOGGER.info("New user attempting to sign in");
        Optional<BloodDonor> donor = Optional.empty();

        Optional<AppRole> role_donor = appRoleRepository.findByRoleName("ROLE_DONOR");
        Optional<AppRole> role_user = appRoleRepository.findByRoleName("ROLE_USER");

        if (!appUserRepository.findByUsername(appUser.getUsername()).isPresent()) {

            Optional<AppUser> user = Optional.empty();
            user = Optional.of(appUserRepository.save(new AppUser(appUser.getPerson(),
                    appUser.getUsername(),
                    passwordEncoder.encode(appUser.getPassword()),
                    role_user.get())));

            user.get().getRoles().add(role_donor.get());

            donor = Optional.of(bloodDonorRepository.save(new BloodDonor(user.get(),
                    bloodGroup,
                    address,
                    whatsAppNumber,
                    lastDonationDate)));
        }
        else {
            Optional<AppUser> user = appUserRepository.findByUsername(appUser.getUsername());
            donor = Optional.of(bloodDonorRepository.save(new BloodDonor(user.get(),
                    bloodGroup,
                    address,
                    whatsAppNumber,
                    lastDonationDate)));

        }
        return donor;
    }

    public BloodDonor saveDonor(String username, String bloodGroup, Address address, String whatsAppNumber, Date lastDonationDate) {
        AppUser user = appUserRepository.findByUsername(username).get();
        BloodDonor donor = new BloodDonor(user, bloodGroup, address, whatsAppNumber, lastDonationDate);
        return bloodDonorRepository.save(donor);
    }
}
