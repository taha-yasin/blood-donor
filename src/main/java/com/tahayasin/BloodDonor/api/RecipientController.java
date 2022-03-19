package com.tahayasin.BloodDonor.api;

import com.tahayasin.BloodDonor.domain.BloodDonor;
import com.tahayasin.BloodDonor.dto.DonorDto;
import com.tahayasin.BloodDonor.dto.FindDonorDto;
import com.tahayasin.BloodDonor.service.BloodRecipientService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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
    @ResponseStatus(HttpStatus.OK)
    public FindDonorDto findDonor(@RequestParam String bloodGroup,
                                  @RequestParam String city,
                                  @RequestParam String pincode,
                                  @RequestParam int pageNo
                                      /*@RequestParam int pageSize,
                                      @RequestParam String sortBy*/) {

//        return bloodRecipientService.findDonor(bloodGroup, city, pincode, pageNo, 10, "address.streetAddress").stream()
//                .map(FindDonorDto::new).collect(Collectors.toList());

        Page<BloodDonor> page = bloodRecipientService.findDonor(bloodGroup,
                city,
                pincode,
                pageNo,
                10,
                "address.streetAddress");

        List<DonorDto> donors = page.getContent().stream().map(DonorDto::new).collect(Collectors.toList());

        FindDonorDto donorsPage = new FindDonorDto(page.getTotalPages(),
                page.getTotalElements(),
                donors);
        
        return  donorsPage;
    }

    @PostMapping("/create-request")
    public
}
