package com.example.MadPtApi.dto.statisticDto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CalendarDailyDto {
    private Long date;
    @JsonProperty("daily_diet_kcal")
    private double dailyDietKcal;
    @JsonProperty("daily_burned_kcal")
    private double dailyBurnedKcal;
}
