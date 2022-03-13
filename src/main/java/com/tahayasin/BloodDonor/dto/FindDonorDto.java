package com.tahayasin.BloodDonor.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FindDonorDto {
    private int numberOfPages;
    private Long numberOfElements;
    private List<DonorDto> donors;
}
