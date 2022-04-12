package com.example.MadPtApi.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@Setter
public class DietFood {
    @Id
    @GeneratedValue
    @Column(name = "diet_food_id")
    private Long id;


    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "diet_id")
    private Diet diet;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "food_id")
    private Food food;

    private double foodWeight;

    // 예) 1컵, 1그릇
    private String unit;
    private int count;

    //==생성 메서드==//
    public static DietFood createDietFood(Food food, double foodWeight) {
        DietFood dietFood = new DietFood();
        dietFood.setFood(food);
        dietFood.setFoodWeight(foodWeight);

        return dietFood;
    }

    //==비지니스 로직==//
    public double getKcal() {
        double kcal = food.getFoodData().getDefault_kcal();
        // 음식 데이터 다시 까봐야됌
        return 0;
    }
}
