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
public class FoodSimpleDataDto {
    @JsonProperty("default_carbohydrate")
    private double defaultCarbohydrate;
    @JsonProperty("default_protein")
    private double defaultProtein;
    @JsonProperty("default_fat")
    private double defaultFat;
}
