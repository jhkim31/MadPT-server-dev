package com.example.MadPtApi.service;

import com.example.MadPtApi.domain.Food;
import com.example.MadPtApi.domain.FoodData;
import com.example.MadPtApi.domain.FoodType;
import com.example.MadPtApi.dto.FoodDto;
import com.example.MadPtApi.repository.FoodRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class FoodServiceTest {

    @Autowired
    FoodRepository foodRepository;

    @Autowired
    FoodService foodService;

    @Test
    @Commit
    public void 음식_리스트_조회() throws Exception {
        // given
        Food food1 = Food.builder()
                .foodName("제육볶음")
                .makerName("CJ")
                .foodData(FoodData.builder()
                        .default_kcal(45.2)
                        .default_carbohydrate(10.1)
                        .default_fat(11.1)
                        .default_protein(12.1)
                        .build())
                .build();

        Food food2 = Food.builder()
                .foodName("제육")
                .makerName("롯데")
                .foodData(FoodData.builder()
                        .default_kcal(45.2)
                        .default_carbohydrate(10.1)
                        .default_fat(11.1)
                        .default_protein(12.1)
                        .build())
                .build();

        // when
        foodService.saveFood(food1);
        foodService.saveFood(food2);

        // then
        List<Food> list = foodService.findFoods("제육");
        assertEquals(2, list.size());
    }

}