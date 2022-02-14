package com.tahayasin.BloodDonor.api;

import com.tahayasin.BloodDonor.domain.AppRole;
import com.tahayasin.BloodDonor.domain.AppUser;
import com.tahayasin.BloodDonor.service.AppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

    private final AppUserService appUserService;

    @PostMapping("/signin")
    public Authentication login(@RequestBody LoginDto loginDto) {
        return appUserService.signin(loginDto.getUsername(), loginDto.getPassword()) ;
    }

    @GetMapping("/users")
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<AppUser>>getUsers() {
        return ResponseEntity.ok().body(appUserService.getUsers());
    }

    @PostMapping("/user/save")
    public ResponseEntity<AppUser>saveUser(@RequestBody AppUser user) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/save").toUriString());
        return ResponseEntity.created(uri).body(appUserService.saveUser(user));
    }

    @PostMapping("/role/save")
    public ResponseEntity<AppRole>saveRole(@RequestBody AppRole role) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role/save").toUriString());
        return ResponseEntity.created(uri).body(appUserService.saveRole(role));
    }


    /***********************************************************
     ********************************************************
     */

    @GetMapping("/msg1")
    String msg1() {
        return "ONE";
    }

    @GetMapping("/msg2")
    String msg2() {
        return "TWO";
    }

    @GetMapping("/msg3")
    String msg3() {
        return "THREE";
    }

    @GetMapping("/open")
    String open() {
        return "OPEN ACCESS";
    }

    @GetMapping("/secure")
    String secured() {
        return "RESTRICTED ACCESS";
    }
}
