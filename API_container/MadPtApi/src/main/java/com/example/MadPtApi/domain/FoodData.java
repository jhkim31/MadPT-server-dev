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
    private double defaultWeight;
    private double defaultKcal;
    private double defaultCarbohydrate;
    private double defaultProtein;
    private double defaultFat;

}
