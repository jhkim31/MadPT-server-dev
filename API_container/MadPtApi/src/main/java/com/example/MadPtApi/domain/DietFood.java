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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "diet_food_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "diet_id")
    private Diet diet;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "food_id")
    private Food food;
    private double dietKcal;
    private double foodWeight;
    // 예) 1컵, 1그릇
    private String unit;
    private int count;

    //==생성 메서드==//
    public static DietFood createDietFood(Food food, double foodKcal, double foodWeight, int count, String unit) {
        DietFood dietFood = new DietFood();
        dietFood.setFood(food);
        dietFood.setDietKcal(foodKcal);
        dietFood.setFoodWeight(foodWeight);
        dietFood.setCount(count);
        dietFood.setUnit(unit);

        return dietFood;
    }

    //==비지니스 로직==//
    public double getKcal() {
        double kcal = food.getFoodData().getDefaultKcal();
        // 음식 데이터 다시 까봐야됌
        return 0;
    }
}
