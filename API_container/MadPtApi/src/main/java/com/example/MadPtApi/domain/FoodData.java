package com.example.MadPtApi.domain;

import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
public class FoodData {
    private double default_kcal;
    private double default_carbohydrate;
    private double default_protein;
    private double default_fat;
}
