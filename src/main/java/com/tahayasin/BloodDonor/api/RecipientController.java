package com.tahayasin.BloodDonor.api;

import com.tahayasin.BloodDonor.domain.BloodDonor;
import com.tahayasin.BloodDonor.repo.BloodDonorRepository;
import com.tahayasin.BloodDonor.service.BloodRecipientService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpServerErrorException;

@RestController
@CrossOrigin("http://localhost:3000/")
@RequestMapping("/blood-recipient")
@RequiredArgsConstructor
public class RecipientController {

    private final BloodRecipientService bloodRecipientService;

//    @GetMapping("/find-donor/{bloodGroup}/{city}/{pincode}/{pageNo}/{pageSize}/{sortBy}")
//    @ResponseStatus(HttpStatus.FOUND)
//    public Page<BloodDonor> findDonor(@PathVariable String bloodGroup,
//                                      @PathVariable String city,
//                                      @PathVariable String pincode,
//                                      @PathVariable int pageNo,
//                                      @PathVariable int pageSize,
//                                      @PathVariable String sortBy) {
//
//        return bloodRecipientService.findDonor(bloodGroup, city, pincode, pageNo, pageSize, sortBy);
//    }

    @GetMapping("/find-donor")
    @ResponseStatus(HttpStatus.FOUND)
    public Page<BloodDonor> findDonor(@RequestParam String bloodGroup,
                                      @RequestParam String city,
                                      @RequestParam String pincode,
                                      @RequestParam int pageNo,
                                      @RequestParam int pageSize,
                                      @RequestParam String sortBy) {

        return bloodRecipientService.findDonor(bloodGroup, city, pincode, pageNo, pageSize, sortBy);
    }

    @PostMapping("/test")
    public String test(@RequestBody String s) {
        return s;
    }
}
