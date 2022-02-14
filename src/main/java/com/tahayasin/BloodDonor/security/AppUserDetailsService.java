package com.tahayasin.BloodDonor.security;

import com.tahayasin.BloodDonor.domain.AppUser;
import com.tahayasin.BloodDonor.repo.AppRoleRepository;
import com.tahayasin.BloodDonor.repo.AppUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import static org.springframework.security.core.userdetails.User.withUsername;

@Component
@AllArgsConstructor
public class AppUserDetailsService implements UserDetailsService {

    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private AppRoleRepository appRoleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        AppUser appUser = appUserRepository.findByUsername(username).orElseThrow(() ->
                new UsernameNotFoundException(String.format("User with name %s does not exist", username)));


        return withUsername(appUser.getUsername())
                .password(appUser.getPassword())
                .authorities(appUser.getRoles())
                .accountExpired(false)
                .accountLocked(false)
                .credentialsExpired(false)
                .disabled(false)
                .build();


//        AppUser appUser = appUserRepository.findByUsername(username);
//        if(appUser == null){
//            throw new UsernameNotFoundException("cannot find username: " + username);
//        }
//
//        List<AppRole> appRoles = this.appRoleRepository.findByUsername(username);
//
//        return new AppUserPrincipal(appUser, appRoles);



//        AppUser appUser = appUserRepository.findByUsername(userName).orElseThrow(() ->
//                new UsernameNotFoundException(String.format("User with name %s does not exist", userName)));

//        Collection<SimpleGrantedAuthority> grantedAuthorities = new HashSet<>();
//        appUser.getRoles().forEach(group->{
//            grantedAuthorities.add(new SimpleGrantedAuthority(group.getRoleName()));
//        });
//        return new User(appUser.getUsername(), appUser.getPassword(), grantedAuthorities);
    }
}

