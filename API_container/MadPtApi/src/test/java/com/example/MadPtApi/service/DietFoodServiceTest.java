package com.example.MadPtApi.service;

import com.example.MadPtApi.domain.DietFood;
import com.example.MadPtApi.repository.DietFoodRepository;
import com.example.MadPtApi.repository.DietRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class DietFoodServiceTest {

    @Autowired
    DietFoodService dietFoodService;

    @Autowired
    DietFoodRepository dietFoodRepository;

    @Test
    public void 식단_리스트_조회() throws Exception {
        // given
        Long timestamp = 1651582676000L;
        Long id = 1L;
        List<DietFood> dietFood = dietFoodService.findDietFood(5L);
        System.out.println(dietFood.size());
        List<DietFood> dietFoodsByDietId = dietFoodRepository.findDietFoodsByDietId(5L);
        System.out.println(dietFoodsByDietId.size());
        // when
        // then
    }
}