package com.example.MadPtApi.dto.foodDto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FoodListResponseDto {
    @JsonProperty("food_list")
    private List<FoodDto> foodDtoList;
}
