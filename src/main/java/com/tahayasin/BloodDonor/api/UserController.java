package com.tahayasin.BloodDonor.api;

import com.tahayasin.BloodDonor.domain.AppRole;
import com.tahayasin.BloodDonor.domain.AppUser;
import com.tahayasin.BloodDonor.service.AppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

    private final AppUserService appUserService;


    @PostMapping("/signin")
    public String login(@RequestBody @Valid LoginDto loginDto) {
        return appUserService.signin(loginDto.getUsername(), loginDto.getPassword()).orElseThrow(() ->
                new HttpServerErrorException(HttpStatus.FORBIDDEN, "Login Failed"));
    }

    @PostMapping("/signup")
    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    @ResponseStatus(HttpStatus.CREATED)
    public AppUser signup(@RequestBody @Valid LoginDto loginDto) {
        return appUserService.signup(loginDto.getFirstName(),
                        loginDto.getLastName(),
                        loginDto.getGender(),
                        loginDto.getDateOfBirth(),
                        loginDto.getUsername(),
                        loginDto.getPassword())
                .orElseThrow(() -> new HttpServerErrorException(HttpStatus.BAD_REQUEST, "User already exists"));
    }

    @GetMapping("/users")
    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<AppUser> getAllUsers() {
        return appUserService.getAllUser();

    }

    @GetMapping("roles")
    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<AppRole> getAllRoles() {
        return appUserService.getAllRoles();
    }
}

