package com.example.MadPtApi.domain;

import com.example.MadPtApi.domain.FoodData;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Food {

    @Id
    @GeneratedValue
    @Column(name = "food_id")
    private Long id;

    private String foodName;

    private String makerName;

    @Embedded
    private FoodData foodData = new FoodData();

    @Enumerated(EnumType.STRING)
    private FoodType foodType;

    @Builder
    public Food(Long id, String foodName, String makerName, FoodData foodData, FoodType foodType) {
        this.id = id;
        this.foodName = foodName;
        this.makerName = makerName;
        this.foodData = foodData;
        this.foodType = foodType;
    }
}
