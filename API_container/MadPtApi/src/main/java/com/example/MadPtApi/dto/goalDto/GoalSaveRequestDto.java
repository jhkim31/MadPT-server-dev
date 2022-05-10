package com.example.MadPtApi.dto.goalDto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GoalSaveRequestDto {
    @JsonProperty("diet_kcal")
    private double dietKcal;
    @JsonProperty("exercise_kcal")
    private double exerciseKcal;
    private double weight;
}
