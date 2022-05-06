package com.example.MadPtApi.dto.dietDto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DailyDietDto {
    @JsonProperty("diet_type")
    private String dietType;
    @JsonProperty("simple_diet_kcal")
    private double simpleDietKcal;
    @JsonProperty("diet_list_by_type")
    List<DietFoodDto> dietFoodDtoList;
}
