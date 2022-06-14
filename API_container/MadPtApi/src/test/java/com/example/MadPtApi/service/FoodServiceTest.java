package com.example.MadPtApi.service;

import com.example.MadPtApi.domain.Food;
import com.example.MadPtApi.domain.FoodData;
import com.example.MadPtApi.repository.FoodRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
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
    public void 음식_리스트_조회() throws Exception {
        // given
        Food food1 = Food.builder()
                .foodName("test001")
                .makerName("CJ")
                .foodData(FoodData.builder()
                        .defaultKcal(45.2)
                        .defaultCarbohydrate(10.1)
                        .defaultFat(11.1)
                        .defaultProtein(12.1)
                        .build())
                .build();

        Food food2 = Food.builder()
                .foodName("test002")
                .makerName("롯데")
                .foodData(FoodData.builder()
                        .defaultKcal(45.2)
                        .defaultCarbohydrate(10.1)
                        .defaultFat(11.1)
                        .defaultProtein(12.1)
                        .build())
                .build();

        // when
        foodService.saveFood(food1);
        foodService.saveFood(food2);

        // then
        List<Food> list = foodService.findFoods("test");
        assertEquals(2, list.size());
    }
    @Test
    public void 음식_조회_디비() throws Exception {
        // given
        String foodName = "꿩불고기";
        // when
        List<Food> list = foodService.findFoods(foodName);
        Food food = list.get(0);
        // then
        assertEquals(500, food.getFoodData().getDefaultWeight());
        assertEquals(368.8, food.getFoodData().getDefaultKcal());
        assertEquals("충주", food.getMakerName());

    }
}