package com.example.MadPtApi.service;

import com.example.MadPtApi.domain.Food;
import com.example.MadPtApi.domain.FoodType;
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
        Food food1 = new Food();
        food1.setFoodName("제육볶음");
        food1.setFoodType(FoodType.NUTRITION);

        Food food2 = new Food();
        food2.setFoodName("제육");
        food2.setFoodType(FoodType.NUTRITION);

        // when
        foodService.saveFood(food1);
        foodService.saveFood(food2);

        // then
        List<Food> list = foodService.findFoods("제육");
        assertEquals(2, list.size());
    }
}