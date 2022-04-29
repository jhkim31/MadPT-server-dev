package com.example.MadPtApi.dto.foodDto;

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
    @JsonProperty("food_id")
    private Long foodId;
    @JsonProperty("food_data")
    FoodDataDto foodData;
}
