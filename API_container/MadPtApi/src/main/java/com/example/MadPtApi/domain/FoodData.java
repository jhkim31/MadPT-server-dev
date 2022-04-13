package com.example.MadPtApi.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FoodData {
    private double default_kcal;
    private double default_carbohydrate;
    private double default_protein;
    private double default_fat;

}
