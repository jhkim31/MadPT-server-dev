package com.example.MadPtApi.dto.memberDto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberSignUpDto {
    private String name;
    private double weight;
    private double height;
    @JsonProperty("gender_type")
    private String genderType;
}
