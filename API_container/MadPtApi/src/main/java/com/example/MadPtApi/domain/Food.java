package com.example.MadPtApi.domain;

import com.example.MadPtApi.domain.FoodData;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
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
}
