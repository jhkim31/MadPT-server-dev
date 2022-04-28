package com.example.MadPtApi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FoodDataDto {
    @JsonProperty("default_weight")
    private double defaultWeight;
    @JsonProperty("default_kcal")
    private double defaultKcal;
    @JsonProperty("default_carbohydrate")
    private double defaultCarbohydrate;
    @JsonProperty("default_protein")
    private double defaultProtein;
    @JsonProperty("default_fat")
    private double defaultFat;
}
