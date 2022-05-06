package com.example.MadPtApi.dto.dietDto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DietSaveRequestDto {
    private Long date;
    @JsonProperty("diet_type")
    private String dietType;
    @JsonProperty("simple_total_kcal")
    private double simpleTotalKcal;
    @JsonProperty("diet_list")
    private List<DietDto> dietList;
}
