package com.example.MadPtApi.controller;
import com.example.MadPtApi.dto.foodDto.FoodDto;
import com.example.MadPtApi.dto.foodDto.FoodListResponseDto;
import com.example.MadPtApi.service.FoodService;
import com.google.gson.JsonObject;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/food")
@RequiredArgsConstructor
public class FoodController {

    private final FoodService foodService;
    private final ModelMapper mapper;

    @GetMapping("/food-list") // "/food/list"
    public FoodListResponseDto getFoodList(@RequestParam(defaultValue = "default",required = false) String food_name) {
        // food list로 보내야됌
        List<FoodDto> foodDtoList = foodService.findFoods(food_name).stream().map(f -> mapper.map(f, FoodDto.class)).collect(Collectors.toList());

        return FoodListResponseDto.builder().foodDtoList(foodDtoList).build();
    }

}