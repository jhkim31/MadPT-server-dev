package com.example.MadPtApi.controller;
import com.example.MadPtApi.domain.Food;
import com.example.MadPtApi.dto.FoodDto;
import com.example.MadPtApi.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class FoodController {

    private final FoodService foodService;
    private final ModelMapper mapper;

    @GetMapping("/food-list")
    public List<FoodDto> getFoodList(@RequestParam(defaultValue = "default",required = false) String food_name) {
        System.out.println("FoodController 실행");
        List<FoodDto> collected = foodService.findFoods(food_name).stream().map(f -> mapper.map(f, FoodDto.class)).collect(Collectors.toList());
        for (FoodDto d : collected) {
            System.out.println(d.getFoodName());
        }
        return foodService.findFoods(food_name).stream().map(f -> mapper.map(f, FoodDto.class)).collect(Collectors.toList());
    }

}