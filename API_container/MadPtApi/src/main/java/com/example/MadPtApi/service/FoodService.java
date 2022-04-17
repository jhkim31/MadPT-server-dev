package com.example.MadPtApi.service;

import com.example.MadPtApi.domain.Food;
import com.example.MadPtApi.domain.FoodData;
import com.example.MadPtApi.domain.FoodType;
import com.example.MadPtApi.dto.FoodDto;
import com.example.MadPtApi.repository.FoodRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class FoodService {

    private final FoodRepository foodRepository;

    // 음식 저장
    @Transactional
    public Long saveFood(Food food) {
        foodRepository.save(food);
        return food.getId();
    }

    // 음식 이름으로 foodList 조회
    public List<Food> findFoods(String foodName) {
        return foodRepository.findFoodByName(foodName);
    }

}
