package com.example.MadPtApi.dto.dietDto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DietDto {
    @JsonProperty("food_id")
    private Long foodId;
    @JsonProperty("food_name")
    private String foodName;
    @JsonProperty("diet_kcal")
    private double dietKcal;
    private double weight;
    private int count;
    private String unit;
    @JsonProperty("is_custom")
    private boolean isCustom;
}
