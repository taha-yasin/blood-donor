package com.tahayasin.BloodDonor.service;

import com.tahayasin.BloodDonor.domain.*;
import com.tahayasin.BloodDonor.repo.*;
import com.tahayasin.BloodDonor.security.JwtProvider;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AppUserService {
    //private static final Logger LOGGER = LoggerFactory.getLogger(AppUserService.class);
    private final AppUserRepository appUserRepository;
    private final AppRoleRepository appRoleRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtProvider jwtProvider;

    /**
     * Sign in a user into the application, with JWT-enabled authentication
     *
     * @param username  username
     * @param password  password
     * @return Optional of the Java Web Token, empty otherwise
     */
    public Optional<String> signin(String username, String password) {
        //LOGGER.info("New user attempting to sign in");
        Optional<String> token = Optional.empty();
        Optional<AppUser> user = appUserRepository.findByUsername(username);
        if (user.isPresent()) {
            try {
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
                token = Optional.of(jwtProvider.createToken(username, user.get().getRoles()));
            } catch (AuthenticationException e){
                //LOGGER.info("Log in failed for user {}", username);

            }
        }
        return token;
    }

    /**
     * Create a new user in the database.
     *
     * @param username username
     * @param password password
     * @param firstName first name
     * @param lastName last name
     * @return Optional of user, empty if the user already exists.
     */
//    public Optional<AppUser> signup(String firstName,
//                                    String lastName,
//                                    String gender,
//                                    Date dateOfBirth,
//                                    String username,
//                                    String password) {
//        //LOGGER.info("New user attempting to sign in");
//        Optional<AppUser> user = Optional.empty();
//        if (!appUserRepository.findByUsername(username).isPresent()) {
//            Optional<AppRole> role = appRoleRepository.findByRoleName("ROLE_USER");
//            user = Optional.of(appUserRepository.save(new AppUser(new Person(firstName,
//                    lastName,
//                    gender,
//                    dateOfBirth),
//                    username,
//                    passwordEncoder.encode(password),
//                    role.get())));
//        }
//        return user;
//    }

    public Optional<AppUser> signup(Person person,
                                    String username,
                                    String password) {
        //LOGGER.info("New user attempting to sign in");
        Optional<AppUser> user = Optional.empty();
        if (!appUserRepository.findByUsername(username).isPresent()) {
            Optional<AppRole> role_user = appRoleRepository.findByRoleName("ROLE_USER");

            user = Optional.of(appUserRepository.save(new AppUser(person,
                    username,
                    passwordEncoder.encode(password),
                    role_user.get())));
        }
        return user;
    }


    public String getUsernameOfCurrentUser() {
        //String headerValue = ((HttpServletRequest)req).getHeader("Authorization");
        Authentication authToken = SecurityContextHolder.getContext().getAuthentication();
        String headerValue = authToken.getCredentials().toString();

        Optional<String > token = Optional.empty();
        if (headerValue != null && headerValue.startsWith("Bearer")) {
            token = Optional.of(headerValue.replace("Bearer", "").trim());
        }

        return jwtProvider.getUsername(token.get());
    }

    public List<AppUser> getAllUser() {
        return appUserRepository.findAll();
    }

    public List<AppRole> getAllRoles() {
        return appRoleRepository.findAll();
    }

    //Prepopulate users for testing purpose
    public AppUser saveUser(AppUser user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return appUserRepository.save(user);
    }


    //Prepopulate roles for testing purpose
    public AppRole saveRole(AppRole role) {
        return appRoleRepository.save(role);
    }

    public AppUser addRoleToUser(String username, String roleName) {
        AppUser appUser = appUserRepository.findByUsername(username).get();
        AppRole appRole = appRoleRepository.findByRoleName(roleName).get();

        appUser.assignRole(appRole);
        return appUserRepository.save(appUser);
    }
}
