package com.example.MadPtApi.dto;

import com.example.MadPtApi.domain.FoodData;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FoodDto {
    @JsonProperty("food_name")
    private String foodName;
    @JsonProperty("maker_name")
    private String makerName;
    @JsonProperty("food_data")
    FoodDataDto foodData;
}
