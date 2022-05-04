package com.example.MadPtApi.dto.dietDto;

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
public class DietResponseDto {
    @JsonProperty("daily_diet_list")
    private List<DailyDietListDto> dailyDietList;
}
