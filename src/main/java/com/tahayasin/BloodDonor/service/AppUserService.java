package com.tahayasin.BloodDonor.service;

import com.tahayasin.BloodDonor.domain.AppRole;
import com.tahayasin.BloodDonor.domain.AppUser;
import com.tahayasin.BloodDonor.repo.AppRoleRepository;
import com.tahayasin.BloodDonor.repo.AppUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AppUserService {
    private final AppUserRepository appUserRepository;
    private final AppRoleRepository appRoleRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public Authentication signin(String username, String password) {
        return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
    }

    public AppUser saveUser(AppUser user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return appUserRepository.save(user);
    }

    public AppRole saveRole(AppRole role) {
        return appRoleRepository.save(role);
    }

    public AppUser getUser(String username) {
        return appUserRepository.findByUsername(username).get();
    }


    public List<AppUser> getUsers() {
        return appUserRepository.findAll();
    }

    public AppUser addRoleToUser(String username, String roleName) {
        AppUser appUser = appUserRepository.findByUsername(username).get();
        AppRole appRole = appRoleRepository.findByRoleName(roleName).get();

        appUser.assignRole(appRole);
        return appUserRepository.save(appUser);
    }
}
