package com.example.MadPtApi.dto;

import com.example.MadPtApi.domain.FoodData;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FoodDto {
    private String foodName;
    private String makerName;
    private double default_kcal;
    private double default_carbohydrate;
    private double default_protein;
    private double default_fat;
    private String foodType;
}
