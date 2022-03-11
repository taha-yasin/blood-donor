package com.tahayasin.BloodDonor.api;

import com.tahayasin.BloodDonor.domain.AppRole;
import com.tahayasin.BloodDonor.domain.AppUser;
import com.tahayasin.BloodDonor.dto.UserLoginDto;
import com.tahayasin.BloodDonor.service.AppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpServerErrorException;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000/")
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final AppUserService appUserService;


    @PostMapping("/signin")
    public String login(@RequestBody @Valid UserLoginDto userLoginDto) {
        return appUserService.signin(userLoginDto.getUsername(), userLoginDto.getPassword()).orElseThrow(() ->
                new HttpServerErrorException(HttpStatus.FORBIDDEN, "Login Failed"));
    }

    @PostMapping("/signup")
    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    @ResponseStatus(HttpStatus.CREATED)
    public AppUser signup(@RequestBody @Valid UserLoginDto userLoginDto) {
        return appUserService.signup(userLoginDto.getPerson(),//.getFirstName(),
                        //userLoginDto.getPersonDto().getLastName(),
                        //userLoginDto.getPersonDto().getGender(),
                        //userLoginDto.getPersonDto().getDateOfBirth(),
                        userLoginDto.getUsername(),
                        userLoginDto.getPassword())
                .orElseThrow(() -> new HttpServerErrorException(HttpStatus.BAD_REQUEST, "User already exists"));
    }

    @GetMapping("/users")
    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<AppUser> getAllUsers() {
        return appUserService.getAllUser();

    }

    @GetMapping("/profile")
    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    public String getUserProfile() {
        return "testing the message after this: " + appUserService.getUsernameOfCurrentUser();

    }

    @GetMapping("roles")
    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<AppRole> getAllRoles() {
        return appUserService.getAllRoles();
    }
}

