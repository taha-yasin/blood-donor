package com.tahayasin.BloodDonor.security;

import com.tahayasin.BloodDonor.domain.AppUser;
import com.tahayasin.BloodDonor.repo.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashSet;

@Component
public class AppUserDetailsService implements UserDetailsService {

    @Autowired
    private AppUserRepository appUserRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        AppUser appUser = appUserRepository.findByUsername(userName);
        if(appUser == null){
            throw new UsernameNotFoundException("cannot find username: " + userName);
        }
//        AppUser appUser = appUserRepository.findByUsername(userName).orElseThrow(() ->
//                new UsernameNotFoundException(String.format("User with name %s does not exist", userName)));

        Collection<SimpleGrantedAuthority> grantedAuthorities = new HashSet<>();
        appUser.getRoles().forEach(group->{
            grantedAuthorities.add(new SimpleGrantedAuthority(group.getRoleName()));
        });
        return new User(appUser.getUsername(), appUser.getPassword(), grantedAuthorities);
    }
}

