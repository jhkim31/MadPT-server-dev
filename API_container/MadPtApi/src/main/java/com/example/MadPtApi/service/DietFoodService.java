package com.example.MadPtApi.service;

import com.example.MadPtApi.domain.DietFood;
import com.example.MadPtApi.repository.DietFoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class DietFoodService {

    private final DietFoodRepository dietFoodRepository;

    /**
     * 식단 불러오기
     */
    public List<DietFood> findDietFood(Long dietFoodId) {
        List<DietFood> dietFoodList = dietFoodRepository.findDietFoodsByDietId(dietFoodId);
        return dietFoodList;
    }
}
