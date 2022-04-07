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

    public FoodData() {
    }

    public FoodData(double default_kcal, double default_carbohydrate, double default_protein, double default_fat) {
        this.default_kcal = default_kcal;
        this.default_carbohydrate = default_carbohydrate;
        this.default_protein = default_protein;
        this.default_fat = default_fat;
    }
}
