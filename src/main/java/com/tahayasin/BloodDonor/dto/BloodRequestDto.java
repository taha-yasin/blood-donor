package com.tahayasin.BloodDonor.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BloodRequestDto {
    private Set<Long> donorIds;
}
