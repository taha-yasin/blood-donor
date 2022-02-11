package com.tahayasin.BloodDonor.api;

import com.tahayasin.BloodDonor.domain.AppRole;
import com.tahayasin.BloodDonor.domain.AppUser;
import com.tahayasin.BloodDonor.service.AppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

    private final AppUserService appUserService;

    @GetMapping("/users")
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

    @PostMapping("/role/addtouser")
    public ResponseEntity<?>addRoleToUser(@RequestBody LoginDto loginDto) {
        appUserService.addRoleToUser(loginDto.getUsername(), loginDto.getRoleName());
        return ResponseEntity.ok().build();
    }
}
