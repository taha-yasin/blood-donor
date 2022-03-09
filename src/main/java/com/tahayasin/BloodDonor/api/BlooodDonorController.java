package com.tahayasin.BloodDonor.api;

import com.tahayasin.BloodDonor.domain.BloodDonor;
import com.tahayasin.BloodDonor.dto.DonorRegistrationDto;
import com.tahayasin.BloodDonor.service.BloodDonorService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpServerErrorException;

import javax.validation.Valid;

@RestController
@CrossOrigin("http://localhost:3000/")
@RequestMapping("/blood-donor")
@RequiredArgsConstructor
public class BlooodDonorController {

    private final BloodDonorService bloodDonorService;

    @PostMapping("/register")
    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    @ResponseStatus(HttpStatus.CREATED)
    public BloodDonor donorRegistration(@RequestBody @Valid DonorRegistrationDto donorRegistrationDto) {

        //return ResponseEntity.ok(HttpStatus.OK);
        return bloodDonorService.donorRegistration(donorRegistrationDto.getAppUser(),
                        donorRegistrationDto.getBloodGroup(),
                        donorRegistrationDto.getAddress(),
                        donorRegistrationDto.getWhatsAppNumber(),
                        donorRegistrationDto.getLastDonationDate())
                .orElseThrow(() -> new HttpServerErrorException(HttpStatus.BAD_REQUEST, "User already exists"));
    }

}
