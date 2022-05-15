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
public class DailySummaryDto {
    private double weight;
    @JsonProperty("burned_kcal")
    private double burnedKcal;
    @JsonProperty("breakfast_kcal")
    private double breakfastKcal;
    @JsonProperty("lunch_kcal")
    private double lunchKcal;
    @JsonProperty("dinner_kcal")
    private double dinnerKcal;
    @JsonProperty("snack_kcal")
    private double snackKcal;
    @JsonProperty("goal_diet_kcal")
    private double goalDietKcal;
    @JsonProperty("goal_exercise_kcal")
    private double goalExerciseKcal;
    @JsonProperty("goal_weight")
    private double goalWeight;
}
