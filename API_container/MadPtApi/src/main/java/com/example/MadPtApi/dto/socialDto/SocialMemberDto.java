package com.example.MadPtApi.dto.socialDto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SocialMemberDto {
    private String name;
    @JsonProperty("burned_kcal")
    private double burnedKcal;
}
