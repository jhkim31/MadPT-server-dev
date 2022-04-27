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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "food_id")
    private Long id;

    @Column(length=1000)
    private String foodName;

    @Column(length=100)
    private String makerName;

    @Embedded
    private FoodData foodData;

    private boolean isCustom;


    @Builder
    public Food(Long id, String foodName, String makerName, FoodData foodData, boolean isCustom) {
        this.id = id;
        this.foodName = foodName;
        this.makerName = makerName;
        this.foodData = foodData;
        this.isCustom = isCustom;
    }

    //==생성 메서드==//

    /**
     * 커스텀 food 생성
     */
    public static Food createCustomFood(String foodName, double kcal) {

        return Food.builder()
                .foodName(foodName)
                .foodData(FoodData.builder().default_kcal(kcal).build())
                .build();
    }
}
